package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class WalletResponse {
    @JsonProperty("walletversion") private String walletVersion;
    @JsonProperty("balance") private BigDecimal balance;
    @JsonProperty("txcount") private long txCount;
    @JsonProperty("keypoololdest") private BigDecimal keyPoolOldest;
    @JsonProperty("unlocked_until") private long unlockedUntil;
    @JsonProperty("keypoolsize") private long keyPoolSize;

    public String getWalletVersion() {
        return walletVersion;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public long getTxCount() {
        return txCount;
    }

    public BigDecimal getKeyPoolOldest() {
        return keyPoolOldest;
    }

    public long getUnlockedUntil() {
        return unlockedUntil;
    }

    public long getKeyPoolSize() {
        return keyPoolSize;
    }

    @Override
    public String toString() {
        return "WalletResponse{" +
                "walletVersion='" + walletVersion + '\'' +
                ", balance=" + balance +
                ", txCount=" + txCount +
                ", keyPoolOldest=" + keyPoolOldest +
                ", unlockedUntil=" + unlockedUntil +
                ", keyPoolSize=" + keyPoolSize +
                '}';
    }
}