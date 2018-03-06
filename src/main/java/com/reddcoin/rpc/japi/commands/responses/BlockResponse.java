package com.reddcoin.rpc.japi.commands.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class BlockResponse {
    @JsonProperty("hash") private String hash;
    @JsonProperty("confirmations") private int numberOfConfirmations;
    @JsonProperty("size") private int size;
    @JsonProperty("height") private int height;
    @JsonProperty("version") private int version;
    @JsonProperty("merkleroot") private String merkleRoot;
    @JsonProperty("tx") private List<String> transactions;
    @JsonProperty("time") private int time;
    @JsonProperty("nonce") private int nonce;
    @JsonProperty("bits") private String bits;
    @JsonProperty("difficulty") private BigDecimal difficulty;
    @JsonProperty("chainwork") private String chainwork;
    @JsonProperty("previousblockhash") private String previousBlockhash;
    @JsonProperty("nextblockhash") private String nextBlockhash;
    @JsonProperty("flags") private String flags;
    @JsonProperty("moneysupply") private BigDecimal moneySupply;
    @JsonProperty("mint") private BigDecimal mint;
    @JsonProperty("entropybit") private int entropybit;
    @JsonProperty("modifier") private String modifier;
    @JsonProperty("modifierchecksum") private String modifierChecksum;
    @JsonProperty("signature") private String signature;

    public String getHash() {
        return hash;
    }

    public int getNumberOfConfirmations() {
        return numberOfConfirmations;
    }

    public int getSize() {
        return size;
    }

    public int getHeight() {
        return height;
    }

    public int getVersion() {
        return version;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public int getTime() {
        return time;
    }

    public int getNonce() {
        return nonce;
    }

    public String getBits() {
        return bits;
    }

    public BigDecimal getDifficulty() {
        return difficulty;
    }

    public String getChainwork() {
        return chainwork;
    }

    public String getPreviousBlockhash() {
        return previousBlockhash;
    }

    public String getNextBlockhash() {
        return nextBlockhash;
    }

    public String getFlags() {
        return flags;
    }

    public BigDecimal getMoneySupply() {
        return moneySupply;
    }

    public BigDecimal getMint() {
        return mint;
    }

    public int getEntropybit() {
        return entropybit;
    }

    public String getModifier() {
        return modifier;
    }

    public String getModifierChecksum() {
        return modifierChecksum;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return "BlockResponse{" +
                "hash='" + hash + '\'' +
                ", numberOfConfirmations=" + numberOfConfirmations +
                ", size=" + size +
                ", height=" + height +
                ", version=" + version +
                ", merkleRoot='" + merkleRoot + '\'' +
                ", transactions=" + transactions +
                ", time=" + time +
                ", nonce=" + nonce +
                ", bits='" + bits + '\'' +
                ", difficulty=" + difficulty +
                ", chainwork='" + chainwork + '\'' +
                ", previousBlockhash='" + previousBlockhash + '\'' +
                ", nextBlockhash='" + nextBlockhash + '\'' +
                ", flags='" + flags + '\'' +
                ", moneySupply=" + moneySupply +
                ", mint=" + mint +
                ", entropybit=" + entropybit +
                ", modifier='" + modifier + '\'' +
                ", modifierChecksum='" + modifierChecksum + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}