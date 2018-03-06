package com.reddcoin.rpc.japi;

import com.reddcoin.rpc.japi.commands.*;
import com.reddcoin.rpc.japi.core.Invoker;
import com.reddcoin.rpc.japi.http.ConnectionConfig;
import com.reddcoin.rpc.japi.http.HttpClient;
import com.reddcoin.rpc.japi.http.NativeHttpClient;

/**
 * The ReddcoinClient is the starting point of the API.
 * It can be constructed using one of the static factory methods.
 * After getting an instance, the entire API can be used in a Fluent style, follow the types in a decent IDE, it will be self-explaining.
 * Some key classes are: {@link WalletCommands} (or one of the other grouped commands, the {@link com.reddcoin.rpc.japi.core.Command} and the {@link com.reddcoin.rpc.japi.core.CommandResult}.
 */
public final class ReddcoinClient {
    private final HttpClient httpClient;

    private ReddcoinClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public static ReddcoinClient create(ConnectionConfig connectionConfig) {
        return new ReddcoinClient(new NativeHttpClient(connectionConfig));
    }

    public static ReddcoinClient create(HttpClient httpClient) {
        return new ReddcoinClient(httpClient);
    }

    public BlockchainCommands blockchainCommands() {
        return new BlockchainCommands(new Invoker(httpClient));
    }

    public EnvironmentCommands environmentCommands() {
        return new EnvironmentCommands(new Invoker(httpClient));
    }

    public MiningCommands miningCommands() {
        return new MiningCommands(new Invoker(httpClient));
    }

    public NetworkCommands networkCommands() {
        return new NetworkCommands(new Invoker(httpClient));
    }

    public WalletCommands walletCommands() {
        return new WalletCommands(new Invoker(httpClient));
    }
}
