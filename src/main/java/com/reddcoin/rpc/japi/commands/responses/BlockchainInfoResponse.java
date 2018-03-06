package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BlockchainInfoResponse {
    @JsonProperty("chain") private String chain;
    @JsonProperty("blocks") private int blocks;
    @JsonProperty("bestblockhash") private String bestBlockhash;
    @JsonProperty("difficulty") private BigDecimal difficulty;
    @JsonProperty("verificationprogress") private BigDecimal verificationProgress;
    @JsonProperty("chainwork") private String chainWork;

    public String getChain() {
        return chain;
    }

    public int getBlocks() {
        return blocks;
    }

    public String getBestBlockhash() {
        return bestBlockhash;
    }

    public BigDecimal getDifficulty() {
        return difficulty;
    }

    public BigDecimal getVerificationProgress() {
        return verificationProgress;
    }

    public String getChainWork() {
        return chainWork;
    }

    @Override
    public String toString() {
        return "BlockchainInfoResponse{" +
                "chain='" + chain + '\'' +
                ", blocks=" + blocks +
                ", bestBlockhash='" + bestBlockhash + '\'' +
                ", difficulty=" + difficulty +
                ", verificationProgress=" + verificationProgress +
                ", chainWork='" + chainWork + '\'' +
                '}';
    }
}