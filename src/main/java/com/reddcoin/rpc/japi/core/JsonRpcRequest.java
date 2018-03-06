package com.reddcoin.rpc.japi.core;

import com.fasterxml.jackson.annotation.JsonProperty;

class JsonRpcRequest {
    @JsonProperty private int id;
    @JsonProperty private String method;
    @JsonProperty private Object[] params;

    JsonRpcRequest(int id, String method, Object[] params) {
        this.id = id;
        this.method = method;
        this.params = params;
    }
}
