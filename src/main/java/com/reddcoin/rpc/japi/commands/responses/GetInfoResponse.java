package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class GetInfoResponse {

    @JsonProperty("version") private int version;
    @JsonProperty("protocolversion") private int protocolVersion;
    @JsonProperty("walletversion") private int walletVersion;
    @JsonProperty("balance") private BigDecimal balance;
    @JsonProperty("stake") private BigDecimal stake;
    @JsonProperty("locked") private boolean locked;
    @JsonProperty("encrypted") private boolean encrypted;
    @JsonProperty("blocks") private int blocks;
    @JsonProperty("timeoffset") private int timeOffset;
    @JsonProperty("moneysupply") private BigDecimal moneySupply;
    @JsonProperty("connections") private int connectionCount;
    @JsonProperty("proxy") private String proxy;
    @JsonProperty("difficulty") private BigDecimal difficulty;
    @JsonProperty("testnet") private boolean testnet;
    @JsonProperty("keypoololdest") private int keypoolOldest;
    @JsonProperty("keypoolsize") private int keypoolSize;
    @JsonProperty("unlocked_until") private int unlockedUntil;
    @JsonProperty("paytxfee") private BigDecimal payTransactionFee;
    @JsonProperty("relayfee") private BigDecimal relayFee;
    @JsonProperty("errors") private String errors;

    public int getVersion() {
        return version;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public int getWalletVersion() {
        return walletVersion;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getStake() {
        return stake;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getTimeOffset() {
        return timeOffset;
    }

    public BigDecimal getMoneySupply() {
        return moneySupply;
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public String getProxy() {
        return proxy;
    }

    public BigDecimal getDifficulty() {
        return difficulty;
    }

    public boolean isTestnet() {
        return testnet;
    }

    public int getKeypoolOldest() {
        return keypoolOldest;
    }

    public int getKeypoolSize() {
        return keypoolSize;
    }

    public int getUnlockedUntil() {
        return unlockedUntil;
    }

    public BigDecimal getPayTransactionFee() {
        return payTransactionFee;
    }

    public BigDecimal getRelayFee() {
        return relayFee;
    }

    public String getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "GetInfoResponse{" +
                "version=" + version +
                ", protocolVersion=" + protocolVersion +
                ", walletVersion=" + walletVersion +
                ", balance=" + balance +
                ", stake=" + stake +
                ", locked=" + locked +
                ", encrypted=" + encrypted +
                ", blocks=" + blocks +
                ", timeOffset=" + timeOffset +
                ", moneySupply=" + moneySupply +
                ", connectionCount=" + connectionCount +
                ", proxy='" + proxy + '\'' +
                ", difficulty=" + difficulty +
                ", testnet=" + testnet +
                ", keypoolOldest=" + keypoolOldest +
                ", keypoolSize=" + keypoolSize +
                ", unlockedUntil=" + unlockedUntil +
                ", payTransactionFee=" + payTransactionFee +
                ", relayFee=" + relayFee +
                ", errors='" + errors + '\'' +
                '}';
    }
}
