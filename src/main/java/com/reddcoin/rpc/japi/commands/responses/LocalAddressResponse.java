package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocalAddressResponse {
    @JsonProperty("address") private String address;
    @JsonProperty("port") private int port;
    @JsonProperty("score") private int score;

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "LocalAddressResponse{" +
                "address='" + address + '\'' +
                ", port=" + port +
                ", score=" + score +
                '}';
    }
}