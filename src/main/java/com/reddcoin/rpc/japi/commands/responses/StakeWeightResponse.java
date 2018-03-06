package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

class StakeWeightResponse {
    @JsonProperty("average") private long average;
    @JsonProperty("total") private long total;

    public long getAverage() {
        return average;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "StakeWeightResponse{" +
                "average=" + average +
                ", total=" + total +
                '}';
    }
}