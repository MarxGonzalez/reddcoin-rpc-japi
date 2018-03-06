package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ReceivedByAccountResponse {
    @JsonProperty("account") private String account;
    @JsonProperty("amount") private BigDecimal amount;
    @JsonProperty("confirmations") private int numberOfConfirmations;

    public String getAccount() {
        return account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getNumberOfConfirmations() {
        return numberOfConfirmations;
    }

    @Override
    public String toString() {
        return "ReceivedByAccountResponse{" +
                "account='" + account + '\'' +
                ", amount=" + amount +
                ", numberOfConfirmations=" + numberOfConfirmations +
                '}';
    }
}