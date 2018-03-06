package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransactionOutputResponse {
    @JsonProperty("bestblock") private String bestblock;
    @JsonProperty("confirmations") private int numberOfConfirmations;
    @JsonProperty("value") private BigDecimal transactionValue;
    @JsonProperty("scriptPubKey") private ScriptPubKeyResponse scriptPubKey;
    @JsonProperty("version") private int version;
    @JsonProperty("coinbase") private boolean coinbase;

    public String getBestblock() {
        return bestblock;
    }

    public int getNumberOfConfirmations() {
        return numberOfConfirmations;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public ScriptPubKeyResponse getScriptPubKey() {
        return scriptPubKey;
    }

    public int getVersion() {
        return version;
    }

    public boolean isCoinbase() {
        return coinbase;
    }

    @Override
    public String toString() {
        return "TransactionOutputResponse{" +
                "bestblock='" + bestblock + '\'' +
                ", numberOfConfirmations=" + numberOfConfirmations +
                ", transactionValue=" + transactionValue +
                ", scriptPubKey=" + scriptPubKey +
                ", version=" + version +
                ", coinbase=" + coinbase +
                '}';
    }
}