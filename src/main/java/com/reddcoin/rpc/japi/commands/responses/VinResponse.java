package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VinResponse {
    @JsonProperty("txid") private String transactionId;
    @JsonProperty("vout") private int vout;
    @JsonProperty("scriptSig") private ScriptSignatureResponse scriptSignature;
    @JsonProperty("sequence") private long sequence;

    public String getTransactionId() {
        return transactionId;
    }

    public int getVout() {
        return vout;
    }

    public ScriptSignatureResponse getScriptSignature() {
        return scriptSignature;
    }

    public long getSequence() {
        return sequence;
    }

    @Override
    public String toString() {
        return "VinResponse{" +
                "transactionId='" + transactionId + '\'' +
                ", vout=" + vout +
                ", scriptSignature=" + scriptSignature +
                ", sequence=" + sequence +
                '}';
    }
}