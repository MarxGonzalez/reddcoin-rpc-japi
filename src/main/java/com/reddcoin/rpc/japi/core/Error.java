package com.reddcoin.rpc.japi.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the error happened after executing the request.
 */
public class Error {
    @JsonProperty private int code;
    @JsonProperty private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    static Error fromException(Exception e) {
        Error error = new Error();
        error.code = -1;
        error.message = e.getMessage();

        return error;
    }

    @Override
    public String toString() {
        return "Error{code=" + code + ", message='" + message + "'}";
    }
}
