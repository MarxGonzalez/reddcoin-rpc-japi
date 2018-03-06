package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetTotalResponse {
    @JsonProperty("totalbytesrecv") private int totalBytesReceived;
    @JsonProperty("totalbytessent") private int totalBytesSent;
    @JsonProperty("timemillis") private long timeMilliseconds;

    public int getTotalBytesReceived() {
        return totalBytesReceived;
    }

    public int getTotalBytesSent() {
        return totalBytesSent;
    }

    public long getTimeMilliseconds() {
        return timeMilliseconds;
    }

    @Override
    public String toString() {
        return "NetTotalResponse{" +
                "totalBytesReceived=" + totalBytesReceived +
                ", totalBytesSent=" + totalBytesSent +
                ", timeMilliseconds=" + timeMilliseconds +
                '}';
    }
}