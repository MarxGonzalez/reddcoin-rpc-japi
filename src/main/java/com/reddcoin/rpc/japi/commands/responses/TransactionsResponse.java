package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class TransactionsResponse {
    @JsonProperty("account") private String account;
    @JsonProperty("address") private String address;
    @JsonProperty("category") private String category;
    @JsonProperty("amount") private BigDecimal amount;
    @JsonProperty("generated") private boolean generated;
    @JsonProperty("confirmations") private int confirmations;
    @JsonProperty("blockhash") private String blockhash;
    @JsonProperty("blockindex") private int blockIndex;
    @JsonProperty("blocktime") private int blockTime;
    @JsonProperty("txid") private String transactionId;
    @JsonProperty("walletconflicts") private List<Object> walletConflicts;
    @JsonProperty("time") private int time;
    @JsonProperty("timereceived") private int timeReceived;

    public String getAccount() {
        return account;
    }

    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean isGenerated() {
        return generated;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public int getBlockIndex() {
        return blockIndex;
    }

    public int getBlockTime() {
        return blockTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public List<Object> getWalletConflicts() {
        return walletConflicts;
    }

    public int getTime() {
        return time;
    }

    public int getTimeReceived() {
        return timeReceived;
    }
}