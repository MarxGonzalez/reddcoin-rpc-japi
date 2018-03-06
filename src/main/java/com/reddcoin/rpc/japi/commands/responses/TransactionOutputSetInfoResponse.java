package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransactionOutputSetInfoResponse {
    @JsonProperty("height") private int height;
    @JsonProperty("bestblock") private String bestBlock;
    @JsonProperty("transactions") private int numberOfTransactions;
    @JsonProperty("txouts") private int numberOfTransactionOutputs;
    @JsonProperty("bytes_serialized") private long bytesSerialized;
    @JsonProperty("hash_serialized") private String hashSerialized;
    @JsonProperty("total_amount") private BigDecimal totalAmount;

    public int getHeight() {
        return height;
    }

    public String getBestBlock() {
        return bestBlock;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public int getNumberOfTransactionOutputs() {
        return numberOfTransactionOutputs;
    }

    public long getBytesSerialized() {
        return bytesSerialized;
    }

    public String getHashSerialized() {
        return hashSerialized;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "TransactionOutputSetInfoResponse{" +
                "height=" + height +
                ", bestBlock='" + bestBlock + '\'' +
                ", numberOfTransactions=" + numberOfTransactions +
                ", numberOfTransactionOutputs=" + numberOfTransactionOutputs +
                ", bytesSerialized=" + bytesSerialized +
                ", hashSerialized='" + hashSerialized + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}