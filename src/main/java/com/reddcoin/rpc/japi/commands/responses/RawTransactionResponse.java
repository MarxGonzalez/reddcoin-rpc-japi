package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RawTransactionResponse {
    @JsonProperty("hex") private String hex;
    @JsonProperty("txid") private String transactionId;
    @JsonProperty("version") private int version;
    @JsonProperty("locktime") private int lockTime;
    @JsonProperty("vin") private List<VinResponse> vin;
    @JsonProperty("vout") private List<VoutResponse> vout;
    @JsonProperty("blockhash") private String blockHash;
    @JsonProperty("confirmations") private int numberOfConfirmations;
    @JsonProperty("time") private int time;
    @JsonProperty("blocktime") private int blockTime;

    public String getHex() {
        return hex;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int getVersion() {
        return version;
    }

    public int getLockTime() {
        return lockTime;
    }

    public List<VinResponse> getVin() {
        return vin;
    }

    public List<VoutResponse> getVout() {
        return vout;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public int getNumberOfConfirmations() {
        return numberOfConfirmations;
    }

    public int getTime() {
        return time;
    }

    public int getBlockTime() {
        return blockTime;
    }

    @Override
    public String toString() {
        return "RawTransactionResponse{" +
                "hex='" + hex + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", version=" + version +
                ", lockTime=" + lockTime +
                ", vin=" + vin +
                ", vout=" + vout +
                ", blockHash='" + blockHash + '\'' +
                ", numberOfConfirmations=" + numberOfConfirmations +
                ", time=" + time +
                ", blockTime=" + blockTime +
                '}';
    }
}