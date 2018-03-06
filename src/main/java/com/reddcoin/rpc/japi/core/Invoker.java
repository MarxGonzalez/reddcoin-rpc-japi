package com.reddcoin.rpc.japi.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.reddcoin.rpc.japi.http.HttpClient;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * This invoker calls the JSON-RPC server with a formatted request and deserializes the response back into a {@link CommandResult}.
 * The returned CommandResult holds the response and - if applicable - the error which happened when calling the JSON-RPC server.
 *
 * Both a synchronous and an asynchronous call style are supported.
 */
public class Invoker {

    private final HttpClient httpClient;
    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
    }

    public Invoker(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    <T> CommandResult<T> invoke(Class destination, JsonRpcRequest request) {
        String jsonRequest = requestToJson(request);
        String jsonResponse = httpClient.sendAndReceive(jsonRequest);

        return toResult(destination, jsonResponse);
    }

    <T> CompletableFuture<CommandResult<T>> invokeAsync(Class destination, JsonRpcRequest request) {
        String jsonRequest = requestToJson(request);

        return httpClient.sendAndReceiveAsync(jsonRequest).thenApply(jsonResponse -> toResult(destination, jsonResponse));
    }

    private String requestToJson(JsonRpcRequest request) {
        try {
            return objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> CommandResult<T> toResult(Class destination, String jsonResponse) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            JsonNode errorNode = rootNode.get("error");
            if (errorNode.isNull()) {
                JsonNode resultNode = rootNode.get("result");
                ObjectReader resultReader = getObjectReader(destination, resultNode);
                T result = resultReader.readValue(resultNode);

                return CommandResult.success(result);
            } else {
                com.reddcoin.rpc.japi.core.Error error = objectMapper.treeToValue(errorNode, com.reddcoin.rpc.japi.core.Error.class);
                return CommandResult.failure(error);
            }
        } catch (IOException e) {
            return CommandResult.failure(com.reddcoin.rpc.japi.core.Error.fromException(e));
        }
    }

    private ObjectReader getObjectReader(Class destination, JsonNode resultNode) {
        if (resultNode.isArray()) {
            CollectionType typeReference = TypeFactory.defaultInstance().constructCollectionType(List.class, destination);
            return objectMapper.readerFor(typeReference);
        } else {
            return objectMapper.readerFor(destination);
        }
    }

}
