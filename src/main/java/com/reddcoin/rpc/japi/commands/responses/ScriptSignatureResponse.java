package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

class ScriptSignatureResponse {
    @JsonProperty("asm") private String asm;
    @JsonProperty("hex") private String hex;

    public String getAsm() {
        return asm;
    }

    public String getHex() {
        return hex;
    }

    @Override
    public String toString() {
        return "ScriptSignatureResponse{" +
                "asm='" + asm + '\'' +
                ", hex='" + hex + '\'' +
                '}';
    }
}