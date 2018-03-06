package com.reddcoin.rpc.japi.core;

import com.reddcoin.rpc.japi.commands.responses.ReceivedByAccountResponse;
import com.reddcoin.rpc.japi.http.HttpClient;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class InvokerTest {

    @Mock HttpClient httpClient;
    @InjectMocks private Invoker invoker;

    @BeforeMethod
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void invoke_SuccessReturningSingleString() {
        when(httpClient.sendAndReceive(anyString())).thenReturn(readFile("/success-single-string.json"));

        CommandResult<String> result = invoker.invoke(String.class, new JsonRpcRequest(1, "sample-method", new Object[]{}));

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getResponse()).isEqualTo("my-string");
    }

    @Test
    public void invoke_SuccessReturningSingleBigDecimal() {
        when(httpClient.sendAndReceive(anyString())).thenReturn(readFile("/success-single-bigdecimal.json"));

        CommandResult<BigDecimal> result = invoker.invoke(BigDecimal.class, new JsonRpcRequest(1, "sample-method", new Object[]{}));

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getResponse()).isBetween(BigDecimal.valueOf(1.000056779d), BigDecimal.valueOf(1.000056781d));
    }

    @Test
    public void invoke_SuccessReturningComplexObject() {
        when(httpClient.sendAndReceive(anyString())).thenReturn(readFile("/success-complex-object.json"));

        CommandResult<ReceivedByAccountResponse> result = invoker.invoke(ReceivedByAccountResponse.class, new JsonRpcRequest(1, "sample-method", new Object[]{}));

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getResponse().getAccount()).isEqualTo("test account");
        assertThat(result.getResponse().getAmount()).isBetween(BigDecimal.valueOf(1234.567890), BigDecimal.valueOf(1234.567890));
        assertThat(result.getResponse().getNumberOfConfirmations()).isEqualTo(6);
    }

    @Test
    public void invoke_SuccessReturningListOfObjects() {
        when(httpClient.sendAndReceive(anyString())).thenReturn(readFile("/success-list-of-objects.json"));

        CommandResult<List<ReceivedByAccountResponse>> result = invoker.invoke(ReceivedByAccountResponse.class, new JsonRpcRequest(1, "sample-method", new Object[]{}));

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getResponse()).hasSize(2);
        assertThat(result.getResponse().get(0).getAccount()).isEqualTo("test account 1");
        assertThat(result.getResponse().get(0).getAmount()).isBetween(BigDecimal.valueOf(1234.567890), BigDecimal.valueOf(1234.567890));
        assertThat(result.getResponse().get(0).getNumberOfConfirmations()).isEqualTo(6);
        assertThat(result.getResponse().get(1).getAccount()).isEqualTo("test account 2");
        assertThat(result.getResponse().get(1).getAmount()).isBetween(BigDecimal.valueOf(0.567890), BigDecimal.valueOf(0.567890));
        assertThat(result.getResponse().get(1).getNumberOfConfirmations()).isEqualTo(6);
    }

    @Test
    public void invoke_SuccessReturningListOfStrings() {
        when(httpClient.sendAndReceive(anyString())).thenReturn(readFile("/success-list-of-strings.json"));

        CommandResult<List<String>> result = invoker.invoke(String.class, new JsonRpcRequest(1, "sample-method", new Object[]{}));

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getResponse()).hasSize(2);
        assertThat(result.getResponse().get(0)).isNotEmpty();
        assertThat(result.getResponse().get(1)).isNotEmpty();
    }

    @Test
    public void invoke_SuccessReturningMap() {
        when(httpClient.sendAndReceive(anyString())).thenReturn(readFile("/success-map.json"));

        CommandResult<Map<String, BigDecimal>> result = invoker.invoke(Map.class, new JsonRpcRequest(1, "sample-method", new Object[]{}));

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getResponse()).hasSize(2);
        assertThat(result.getResponse()).contains(new AbstractMap.SimpleEntry<>("account 1", BigDecimal.valueOf(-6020.94794028d)));
        assertThat(result.getResponse()).contains(new AbstractMap.SimpleEntry<>("account 2", BigDecimal.valueOf(1.20000000)));
    }

    String readFile(String fileName) {
        InputStream inputStream = Invoker.class.getResourceAsStream(fileName);

        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}