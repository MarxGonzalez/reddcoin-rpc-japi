package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class ReceivedByAddressResponse {
    @JsonProperty("address") private String address;
    @JsonProperty("account") private String account;
    @JsonProperty("amount") private BigDecimal amount;
    @JsonProperty("confirmations") private int numberOfConfirmations;
    @JsonProperty("txids") private List<String> transactionIdentifiers;

    public String getAddress() {
        return address;
    }

    public String getAccount() {
        return account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getNumberOfConfirmations() {
        return numberOfConfirmations;
    }

    public List<String> getTransactionIdentifiers() {
        return transactionIdentifiers;
    }

    @Override
    public String toString() {
        return "ReceivedByAddressResponse{" +
                "address='" + address + '\'' +
                ", account='" + account + '\'' +
                ", amount=" + amount +
                ", numberOfConfirmations=" + numberOfConfirmations +
                ", transactionIdentifiers=" + transactionIdentifiers +
                '}';
    }
}