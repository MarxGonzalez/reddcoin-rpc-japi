package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class PeerInfoResponse {
    @JsonProperty("addr") private String address;
    @JsonProperty("services") private String services;
    @JsonProperty("lastsend") private int lastSend;
    @JsonProperty("lastrecv") private int lastReceived;
    @JsonProperty("bytessent") private int bytesSent;
    @JsonProperty("bytesrecv") private int bytesReceived;
    @JsonProperty("conntime") private int connectionTime;
    @JsonProperty("pingtime") private BigDecimal pingTime;
    @JsonProperty("version") private int version;
    @JsonProperty("subver") private String subVersion;
    @JsonProperty("inbound") private boolean inbound;
    @JsonProperty("startingheight") private int startingHeight;
    @JsonProperty("banscore") private int banScore;
    @JsonProperty("syncnode") private boolean syncNode;

    public String getAddress() {
        return address;
    }

    public String getServices() {
        return services;
    }

    public int getLastSend() {
        return lastSend;
    }

    public int getLastReceived() {
        return lastReceived;
    }

    public int getBytesSent() {
        return bytesSent;
    }

    public int getBytesReceived() {
        return bytesReceived;
    }

    public int getConnectionTime() {
        return connectionTime;
    }

    public BigDecimal getPingTime() {
        return pingTime;
    }

    public int getVersion() {
        return version;
    }

    public String getSubVersion() {
        return subVersion;
    }

    public boolean isInbound() {
        return inbound;
    }

    public int getStartingHeight() {
        return startingHeight;
    }

    public int getBanScore() {
        return banScore;
    }

    public boolean isSyncNode() {
        return syncNode;
    }

    @Override
    public String toString() {
        return "PeerInfoResponse{" +
                "address='" + address + '\'' +
                ", services='" + services + '\'' +
                ", lastSend=" + lastSend +
                ", lastReceived=" + lastReceived +
                ", bytesSent=" + bytesSent +
                ", bytesReceived=" + bytesReceived +
                ", connectionTime=" + connectionTime +
                ", pingTime=" + pingTime +
                ", version=" + version +
                ", subVersion='" + subVersion + '\'' +
                ", inbound=" + inbound +
                ", startingHeight=" + startingHeight +
                ", banScore=" + banScore +
                ", syncNode=" + syncNode +
                '}';
    }
}