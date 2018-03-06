package com.reddcoin.rpc.japi.commands;

import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.core.Invoker;
import com.reddcoin.rpc.japi.core.CommandImpl;
import com.reddcoin.rpc.japi.commands.responses.NetTotalResponse;
import com.reddcoin.rpc.japi.commands.responses.NetworkInfoResponse;
import com.reddcoin.rpc.japi.commands.responses.PeerInfoResponse;

import java.util.List;

public class NetworkCommands {
    private final Invoker invoker;

    public NetworkCommands(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Retrieves the number of connections to other nodes in the network.
     */
    public Command<Long> getConnectionCountCommand() {
        return new CommandImpl<>(invoker, Long.class, "getconnectioncount");
    }

    /**
     * Retrieves information about the network traffic.
     */
    public Command<NetTotalResponse> getNetworkTotalsCommand() {
        return new CommandImpl<>(invoker, NetTotalResponse.class, "getnettotals");
    }

    /**
     * Retrieves information about the node's connection to the network.
     */
    public Command<NetworkInfoResponse> getNetworkInfoCommand() {
        return new CommandImpl<>(invoker, NetworkInfoResponse.class, "getnetworkinfo");
    }

    /**
     * Retrieves information about each node this node has a connection with; its peer nodes.
     */
    public Command<List<PeerInfoResponse>> getPeerInfoCommand() {
        return new CommandImpl<>(invoker, List.class, "getpeerinfo");
    }
}
