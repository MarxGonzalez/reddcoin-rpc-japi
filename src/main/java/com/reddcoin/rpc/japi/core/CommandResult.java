package com.reddcoin.rpc.japi.core;

/**
 * Represents the result of the executed {@link Command}.
 * Provides public methods which can be used to retrieve the actual response or the encountered error.
 *
 * @param <T> Generic type of the enclosed {@link #getResponse response}
 */
public class CommandResult<T> {

    private T response;
    private Error error;

    private CommandResult(T response) {
        this.response = response;
    }

    private CommandResult(Error error) {
        this.error = error;
    }

    static <T> CommandResult<T> success(T response) {
        return new CommandResult<>(response);
    }

    static <T> CommandResult<T> failure(Error error) {
        return new CommandResult<>(error);
    }

    public boolean isSuccess() {
        return error == null;
    }

    public T getResponse() {
        return response;
    }

    public Error getError() {
        return error;
    }
}
