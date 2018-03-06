package com.reddcoin.rpc.japi.commands;

import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.core.CommandImpl;
import com.reddcoin.rpc.japi.core.Invoker;
import com.reddcoin.rpc.japi.commands.responses.GetInfoResponse;

/**
 * Various commands
 */
public class EnvironmentCommands {
    private final Invoker invoker;

    public EnvironmentCommands(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Retrieves a summary for the node, wallet and network.
     */
    public Command<GetInfoResponse> getInfoCommand() {
        return new CommandImpl<>(invoker, GetInfoResponse.class, "getinfo");
    }

    /**
     * Sends a ping to the server, returning null if the connection is valid.
     */
    public Command<Void> pingCommand() {
        return new CommandImpl<>(invoker, Void.class, "ping");

    }
}
