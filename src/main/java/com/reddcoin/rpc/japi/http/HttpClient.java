package com.reddcoin.rpc.japi.http;

import java.util.concurrent.CompletableFuture;

public interface HttpClient {

    String sendAndReceive(String request);

    CompletableFuture<String> sendAndReceiveAsync(String request);
}
