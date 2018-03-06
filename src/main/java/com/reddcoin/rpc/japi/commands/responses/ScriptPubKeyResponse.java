package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class ScriptPubKeyResponse {
    @JsonProperty("asm") private String asm;
    @JsonProperty("hex") private String hex;
    @JsonProperty("type") private String type;
    @JsonProperty("reqSigs") private int requestSigs;
    @JsonProperty("addresses") private List<String> addresses;

    public String getAsm() {
        return asm;
    }

    public String getHex() {
        return hex;
    }

    public String getType() {
        return type;
    }

    public int getRequestSigs() {
        return requestSigs;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        return "ScriptPubKeyResponse{" +
                "asm='" + asm + '\'' +
                ", hex='" + hex + '\'' +
                ", type='" + type + '\'' +
                ", requestSigs=" + requestSigs +
                ", addresses=" + addresses +
                '}';
    }
}