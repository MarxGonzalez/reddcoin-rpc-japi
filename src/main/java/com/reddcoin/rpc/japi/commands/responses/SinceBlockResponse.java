package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class SinceBlockResponse {
    @JsonProperty("account") private String account;
    @JsonProperty("address") private String address;
    @JsonProperty("category") private String category;
    @JsonProperty("amount") private BigDecimal amount;
    @JsonProperty("confirmations") private int numberOfConfirmations;
    @JsonProperty("generated") private boolean isGenerated;
    @JsonProperty("blockhash") private String blockhash;
    @JsonProperty("blockindex") private int blockindex;
    @JsonProperty("blocktime") private int blocktime;
    @JsonProperty("txid") private String transactionId;
    @JsonProperty("walletconflicts") private List<Object> walletConflicts;
    @JsonProperty("time") private int time;
    @JsonProperty("timereceived") private int timeReceived;
    @JsonProperty("fee") private BigDecimal fee;
}