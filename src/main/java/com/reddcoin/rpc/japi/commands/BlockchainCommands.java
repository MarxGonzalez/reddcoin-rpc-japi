package com.reddcoin.rpc.japi.commands;

import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.core.CommandImpl;
import com.reddcoin.rpc.japi.core.Invoker;
import com.reddcoin.rpc.japi.commands.responses.BlockResponse;
import com.reddcoin.rpc.japi.commands.responses.BlockchainInfoResponse;
import com.reddcoin.rpc.japi.commands.responses.TransactionOutputResponse;
import com.reddcoin.rpc.japi.commands.responses.TransactionOutputSetInfoResponse;

public class BlockchainCommands {
    private final Invoker invoker;

    public BlockchainCommands(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Retrieves the block header hash of the most recent block in the local best-block-chain.
     */
    public Command<String> getBestBlockHashCommand() {
        return new CommandImpl<>(invoker, String.class, "getbestblockhash");
    }

    /**
     * Retrieves information about the blockchain.
     */
    public Command<BlockchainInfoResponse> getBlockchainInfoCommand() {
        return new CommandImpl<>(invoker, BlockchainInfoResponse.class, "getblockchaininfo");
    }

    /**
     * Retrieves the block with the given hash.
     */
    public Command<BlockResponse> getBlockCommand(String hash) {
        return new CommandImpl<>(invoker, BlockResponse.class, "getblock", hash);
    }

    /**
     * Retrieves the number of blocks in the longest blockchain.
     */
    public Command<Long> blockCountCommand() {
        return new CommandImpl<>(invoker, Long.class, "getblockcount");
    }

    /**
     * Retrieves the block header hash in the local best-block-chain for the given block height.
     */
    public Command<String> getBlockHashCommand(int blockHeight) {
        return new CommandImpl<>(invoker, String.class, "getblockhash", blockHeight);
    }

    /**
     * Retrieves details about a (unspent) transaction output for a given transactionId and a output index number of the output within the transaction.
     * This also returns unconfirmed outputs from the memory pool.
     */
    public Command<TransactionOutputResponse> getTransactionOutputCommand(String transactionId, int voutNumber) {
        return getTransactionOutputCommand(transactionId, voutNumber, true);
    }

    /**
     * Retrieves details about a (unspent) transaction output for a given transactionId and a output index number of the output within the transaction, with an option to also return unconfirmed outputs from the memory pool.
     */
    public Command<TransactionOutputResponse> getTransactionOutputCommand(String transactionId, int voutNumber, boolean includeMemoryPool) {
        return new CommandImpl<>(invoker, TransactionOutputResponse.class, "gettxout", transactionId, voutNumber, includeMemoryPool);
    }

    /**
     * Retrieves the statistics of the unspent transaction set.
     */
    public Command<TransactionOutputSetInfoResponse> getTransactionOutputSetInfoCommand() {
        return new CommandImpl<>(invoker, TransactionOutputSetInfoResponse.class, "gettxoutsetinfo");
    }

}
