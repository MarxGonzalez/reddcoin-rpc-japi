package com.reddcoin.rpc.japi.commands;

import com.reddcoin.rpc.japi.commands.responses.MiningInfoResponse;
import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.core.CommandImpl;
import com.reddcoin.rpc.japi.core.Invoker;

public class MiningCommands {
    private final Invoker invoker;

    public MiningCommands(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Retrieves mining related information.
     */
    public Command<MiningInfoResponse> getMiningInfoCommand() {
        return new CommandImpl<>(invoker, MiningInfoResponse.class, "getmininginfo");
    }

    /**
     * Retrieves the estimated current or historical network hashes per second based on the last 120 (default) blocks.
     */
    public Command<Long> getNetworkHashesPerSecondCommand() {
        return getNetworkHashesPerSecondCommand(120, -1);
    }

    /**
     * Retrieves the estimated current or historical network hashes per second based on the last n blocks.
     *
     * @param numberOfBlocks The number of blocks to average together for calculating the estimated hashes per second.Use -1 to average all blocks produced since the last difficulty change.
     * @param heighestBlockHeight The height of the last block to use for calculating the average,
     */
    public Command<Long> getNetworkHashesPerSecondCommand(int numberOfBlocks, int heighestBlockHeight) {
        return new CommandImpl<>(invoker, Long.class, "getnetworkhashps", numberOfBlocks, heighestBlockHeight);
    }
}
