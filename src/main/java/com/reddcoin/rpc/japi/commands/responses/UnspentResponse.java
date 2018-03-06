package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class UnspentResponse {
    @JsonProperty("txid") private String transactionId;
    @JsonProperty("vout") private int vout;
    @JsonProperty("address") private String address;
    @JsonProperty("account") private String account;
    @JsonProperty("scriptPubKey") private String scriptPubKey;
    @JsonProperty("amount") private BigDecimal amount;
    @JsonProperty("confirmations") private int numberOfConfirmations;

    public String getTransactionId() {
        return transactionId;
    }

    public int getVout() {
        return vout;
    }

    public String getAddress() {
        return address;
    }

    public String getAccount() {
        return account;
    }

    public String getScriptPubKey() {
        return scriptPubKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getNumberOfConfirmations() {
        return numberOfConfirmations;
    }

    @Override
    public String toString() {
        return "UnspentResponse{" +
                "transactionId='" + transactionId + '\'' +
                ", vout=" + vout +
                ", address='" + address + '\'' +
                ", account='" + account + '\'' +
                ", scriptPubKey='" + scriptPubKey + '\'' +
                ", amount=" + amount +
                ", numberOfConfirmations=" + numberOfConfirmations +
                '}';
    }
}