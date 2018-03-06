package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MiningInfoResponse {
    @JsonProperty("blocks") private int numberOfBlocks;
    @JsonProperty("currentblocksize") private int currentBlockSize;
    @JsonProperty("currentblocktx") private int currentBlockTransaction;
    @JsonProperty("difficulty") private BigDecimal difficulty;
    @JsonProperty("errors") private String errors;
    @JsonProperty("genproclimit") private int genProcLimit;
    @JsonProperty("networkhashps") private int networkHashps;
    @JsonProperty("pooledtx") private int pooledTransaction;
    @JsonProperty("testnet") private boolean testNet;
    @JsonProperty("generate") private boolean generate;
    @JsonProperty("hashespersec") private int hashesPerSec;
    @JsonProperty("stakeweight") private StakeWeightResponse stakeWeight;
    @JsonProperty("stakeinterest") private int stakeInterest;
    @JsonProperty("netstakeweight") private long netStakeWeight;

    public int getNumberOfBlocks() {
        return numberOfBlocks;
    }

    public int getCurrentBlockSize() {
        return currentBlockSize;
    }

    public int getCurrentBlockTransaction() {
        return currentBlockTransaction;
    }

    public BigDecimal getDifficulty() {
        return difficulty;
    }

    public String getErrors() {
        return errors;
    }

    public int getGenProcLimit() {
        return genProcLimit;
    }

    public int getNetworkHashps() {
        return networkHashps;
    }

    public int getPooledTransaction() {
        return pooledTransaction;
    }

    public boolean isTestNet() {
        return testNet;
    }

    public boolean isGenerate() {
        return generate;
    }

    public int getHashesPerSec() {
        return hashesPerSec;
    }

    public StakeWeightResponse getStakeWeight() {
        return stakeWeight;
    }

    public int getStakeInterest() {
        return stakeInterest;
    }

    public long getNetStakeWeight() {
        return netStakeWeight;
    }

    @Override
    public String toString() {
        return "MiningInfoResponse{" +
                "numberOfBlocks=" + numberOfBlocks +
                ", currentBlockSize=" + currentBlockSize +
                ", currentBlockTransaction=" + currentBlockTransaction +
                ", difficulty=" + difficulty +
                ", errors='" + errors + '\'' +
                ", genProcLimit=" + genProcLimit +
                ", networkHashps=" + networkHashps +
                ", pooledTransaction=" + pooledTransaction +
                ", testNet=" + testNet +
                ", generate=" + generate +
                ", hashesPerSec=" + hashesPerSec +
                ", stakeWeight=" + stakeWeight +
                ", stakeInterest=" + stakeInterest +
                ", netStakeWeight=" + netStakeWeight +
                '}';
    }
}