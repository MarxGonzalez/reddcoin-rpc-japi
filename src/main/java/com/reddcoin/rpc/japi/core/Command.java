package com.reddcoin.rpc.japi.core;

import java.util.concurrent.CompletableFuture;

/**
 * Represents the actual command, providing a synchronous and an asynchronous method to execute the command and get the response back.
 *
 * @param <T> Type of the returned response. E.g. {@link java.math.BigDecimal} or {@link com.reddcoin.rpc.japi.commands.responses.WalletResponse}.
 */
public interface Command<T> {

    /**
     * Executes this command synchronously.
     *
     * @return The result
     */
    CommandResult<T> execute();

    /**
     * Executes this command asynchronously.
     *
     * @return The result
     */
    CompletableFuture<CommandResult<T>> executeAsync();

}
