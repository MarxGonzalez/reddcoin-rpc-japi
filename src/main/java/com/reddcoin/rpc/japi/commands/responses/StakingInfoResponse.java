package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class StakingInfoResponse {
    @JsonProperty("enabled") private boolean isEnabled;
    @JsonProperty("staking") private boolean isStaking;
    @JsonProperty("currentblocksize") private int currentBlockSize;
    @JsonProperty("currentblocktx") private int currentBlockTransaction;
    @JsonProperty("pooledtx") private int pooledTransaction;
    @JsonProperty("difficulty") private BigDecimal difficulty;
    @JsonProperty("search-interval") private int searchInterval;
    @JsonProperty("averageweight") private int averageWeight;
    @JsonProperty("totalweight") private int totalWeight;
    @JsonProperty("netstakeweight") private long netStakeWeight;
    @JsonProperty("expectedtime") private long expectedTimeInSeconds;

    public boolean isEnabled() {
        return isEnabled;
    }

    public boolean isStaking() {
        return isStaking;
    }

    public int getCurrentBlockSize() {
        return currentBlockSize;
    }

    public int getCurrentBlockTransaction() {
        return currentBlockTransaction;
    }

    public int getPooledTransaction() {
        return pooledTransaction;
    }

    public BigDecimal getDifficulty() {
        return difficulty;
    }

    public int getSearchInterval() {
        return searchInterval;
    }

    public int getAverageWeight() {
        return averageWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public long getNetStakeWeight() {
        return netStakeWeight;
    }

    public long getExpectedTimeInSeconds() {
        return expectedTimeInSeconds;
    }

    @Override
    public String toString() {
        return "StakingInfoResponse{" +
                "isEnabled=" + isEnabled +
                ", isStaking=" + isStaking +
                ", currentBlockSize=" + currentBlockSize +
                ", currentBlockTransaction=" + currentBlockTransaction +
                ", pooledTransaction=" + pooledTransaction +
                ", difficulty=" + difficulty +
                ", searchInterval=" + searchInterval +
                ", averageWeight=" + averageWeight +
                ", totalWeight=" + totalWeight +
                ", netStakeWeight=" + netStakeWeight +
                ", expectedTimeInSeconds=" + expectedTimeInSeconds +
                '}';
    }
}