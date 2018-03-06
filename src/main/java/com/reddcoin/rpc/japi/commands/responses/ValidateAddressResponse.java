package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateAddressResponse {
    @JsonProperty("isvalid") private boolean isvalid;
    @JsonProperty("address") private String address;
    @JsonProperty("ismine") private boolean isMine;
    @JsonProperty("isscript") private boolean isScript;
    @JsonProperty("pubkey") private String pubKey;
    @JsonProperty("iscompressed") private boolean isCompressed;
    @JsonProperty("account") private String account;
}