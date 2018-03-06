package com.reddcoin.rpc.japi.core;

import java.util.concurrent.CompletableFuture;

public class CommandImpl<T> implements Command<T> {
    private final Invoker invoker;
    private final Class destination;
    private final String method;
    private final Object[] parameters;

    public CommandImpl(Invoker invoker, Class destination, String method, Object... parameters) {
        this.invoker = invoker;
        this.destination = destination;
        this.method = method;
        this.parameters = parameters;
    }

    @Override
    public CommandResult<T> execute() {
        JsonRpcRequest request = new JsonRpcRequest(1, method, parameters);

        return invoker.invoke(destination, request);
    }

    @Override
    public CompletableFuture<CommandResult<T>> executeAsync() {
        JsonRpcRequest request = new JsonRpcRequest(1, method, parameters);

        return invoker.invokeAsync(destination, request);
    }
}