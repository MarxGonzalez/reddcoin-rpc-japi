package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class VoutResponse {
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("n") private int number;
    @JsonProperty("scriptPubKey") private ScriptPubKeyResponse scriptPubKey;

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setScriptPubKey(ScriptPubKeyResponse scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    @Override
    public String toString() {
        return "VoutResponse{" +
                "value=" + value +
                ", number=" + number +
                ", scriptPubKey=" + scriptPubKey +
                '}';
    }
}