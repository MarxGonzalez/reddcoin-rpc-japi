package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class NetworkInfoResponse {
    @JsonProperty("version") private int version;
    @JsonProperty("protocolversion") private int protocolVersion;
    @JsonProperty("timeoffset") private int timeOffset;
    @JsonProperty("connections") private int connections;
    @JsonProperty("proxy") private String proxy;
    @JsonProperty("relayfee") private BigDecimal relayFee;
    @JsonProperty("localaddresses") private List<LocalAddressResponse> localaddresses;

    public int getVersion() {
        return version;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public int getTimeOffset() {
        return timeOffset;
    }

    public int getConnections() {
        return connections;
    }

    public String getProxy() {
        return proxy;
    }

    public BigDecimal getRelayFee() {
        return relayFee;
    }

    public List<LocalAddressResponse> getLocaladdresses() {
        return localaddresses;
    }

    @Override
    public String toString() {
        return "NetworkInfoResponse{" +
                "version=" + version +
                ", protocolVersion=" + protocolVersion +
                ", timeOffset=" + timeOffset +
                ", connections=" + connections +
                ", proxy='" + proxy + '\'' +
                ", relayFee=" + relayFee +
                ", localaddresses=" + localaddresses +
                '}';
    }
}