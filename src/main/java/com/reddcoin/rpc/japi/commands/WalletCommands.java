package com.reddcoin.rpc.japi.commands;

import com.reddcoin.rpc.japi.commands.responses.*;
import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.core.CommandImpl;
import com.reddcoin.rpc.japi.core.Invoker;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class WalletCommands {
    private final Invoker invoker;

    public WalletCommands(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Retrieves the account name associated with the given address.
     */
    public Command<String> getAccountCommand(String reddcoinAddress) {
        return new CommandImpl<>(invoker, String.class, "getaccount", reddcoinAddress);
    }

    /**
     * Retrieves the address on which to receive payments for the given account name. Creates a new address if no account was found with that name.
     */
    public Command<String> getAccountAddressCommand(String account) {
        return new CommandImpl<>(invoker, String.class, "getaccountaddress", account);
    }

    /**
     * Retrieves the addresses registered on the account with the given account name.
     */
    public Command<List<String>> getAddressesByAccountCommand(String account) {
        return new CommandImpl<>(invoker, String.class, "getaddressesbyaccount", account);
    }

    /**
     * Retrieves the total balance for all accounts in this wallet.
     */
    public Command<BigDecimal> getBalanceCommand() {
        return new CommandImpl<>(invoker, BigDecimal.class, "getbalance");
    }

    /**
     * Retrieves the balance for the account with the given account name.
     */
    public Command<BigDecimal> getBalanceCommand(String account) {
        return new CommandImpl<>(invoker, BigDecimal.class, "getbalance", account);
    }

    /**
     * Retrieves the balance for the account with the given account name, for which the underlying transaction matches the given 'minimum amount of confirmations'.
     * Note: this restriction only applies for externally generated transactions.
     */
    public Command<BigDecimal> getBalanceCommand(String account, int minimumAmountOfConfirmations) {
        return new CommandImpl<>(invoker, BigDecimal.class, "getbalance", account, minimumAmountOfConfirmations);
    }

    /**
     * Retrieves the total amount of Reddcoin received by staking.
     */
    public Command<BigDecimal> getInterestCommand() {
        return new CommandImpl<>(invoker, BigDecimal.class, "getinterest");
    }

    /**
     * Retrieves the raw details of the transaction identified by the given transactionId.
     */
    public Command<RawTransactionResponse> getRawTransactionCommand(String transactionId) {
        return new CommandImpl<>(invoker, RawTransactionResponse.class, "getrawtransaction", transactionId, 1);
    }

    /**
     * Retrieves the amount of Reddcoins received on the account with the given account name.
     */
    public Command<BigDecimal> getReceivedByAccountCommand(String account) {
        return new CommandImpl<>(invoker, BigDecimal.class, "getreceivedbyaccount", account);
    }

    /**
     * Retrieves the amount of Reddcoins received on the account with the given account name, for which the underlying transaction matches the given 'minimum amount of confirmations'.
     * Note: this restriction only applies for externally generated transactions.
     */
    public Command<BigDecimal> getReceivedByAccountCommand(String account, int minimumAmountOfConfirmations) {
        return new CommandImpl<>(invoker, BigDecimal.class, "getreceivedbyaccount", account, minimumAmountOfConfirmations);
    }

    /**
     * Retrieves the amount of Reddcoins received on the given address.
     */
    public Command<BigDecimal> getReceivedByAddressCommand(String reddcoinAddress) {
        return new CommandImpl<>(invoker, BigDecimal.class, "getreceivedbyaddress", reddcoinAddress);
    }

    /**
     * Retrieves the amount of Reddcoins received on the given address, for which the underlying transaction matches the given 'minimum amount of confirmations'.
     * Note: this restriction only applies for externally generated transactions.
     */
    public Command<BigDecimal> getReceivedByAddressCommand(String reddcoinAddress, int minimumAmountOfConfirmations) {
        return new CommandImpl<>(invoker, BigDecimal.class, "getreceivedbyaddress", reddcoinAddress, minimumAmountOfConfirmations);
    }

    /**
     * Retrieves details about the staking process.
     */
    public Command<StakingInfoResponse> getStakingInfoCommand() {
        return new CommandImpl<>(invoker, StakingInfoResponse.class, "getstakinginfo");
    }

    /**
     * Retrieves the transaction identified by the given transactionId.
     */
    public Command<TransactionResponse> getTransactionCommand(String transactionId) {
        return new CommandImpl<>(invoker, TransactionResponse.class, "gettransaction", transactionId);
    }

    /**
     * Retrieves the total unconfirmed balance of the wallet.
     */
    public Command<BigDecimal> getUnconfirmedBalanceCommand() {
        return new CommandImpl<>(invoker, BigDecimal.class, "getunconfirmedbalance");
    }

    /**
     * Retrieves details about the wallet.
     */
    public Command<WalletResponse> getWalletInfoCommand() {
        return new CommandImpl<>(invoker, WalletResponse.class, "getwalletinfo");
    }

    /**
     * Retrieves all accounts in the wallet and their balances.
     */
    public Command<Map<String, BigDecimal>> listAccountsCommand() {
        return new CommandImpl<>(invoker, Map.class, "listaccounts");
    }

    /**
     * Retrieves all accounts in the wallet and their balances, for which the underlying transaction matches the given 'minimum amount of confirmations'.
     * Note: this restriction only applies for externally generated transactions.
     */
    public Command<Map<String, BigDecimal>> listAccountsCommand(int minimumAmountOfConfirmations) {
        return new CommandImpl<>(invoker, Map.class, "listaccounts", minimumAmountOfConfirmations);
    }

    /**
     * Retrieves all accounts in the wallet and the amount received by these accounts.
     */
    public Command<List<ReceivedByAccountResponse>> listReceivedByAccountCommand() {
        return new CommandImpl<>(invoker, ReceivedByAccountResponse.class, "listreceivedbyaccount");
    }

    /**
     * Retrieves all accounts in the wallet and the amount received by these accounts, for which the underlying transaction matches the given 'minimum amount of confirmations'.
     * Note: this restriction only applies for externally generated transactions.
     */
    public Command<List<ReceivedByAccountResponse>> listReceivedByAccountCommand(int minimumAmountOfConfirmations) {
        return new CommandImpl<>(invoker, ReceivedByAccountResponse.class, "listreceivedbyaccount", minimumAmountOfConfirmations);
    }

    /**
     * Retrieves the addresses in the wallet and the amount received on these addresses.
     */
    public Command<List<ReceivedByAddressResponse>> listReceivedByAddressCommand() {
        return new CommandImpl<>(invoker, ReceivedByAddressResponse.class, "listreceivedbyaddress");
    }

    /**
     * Retrieves the addresses in the wallet and the amount received on these addresses, for which the underlying transaction matches the given 'minimum amount of confirmations'.
     * Note: this restriction only applies for externally generated transactions.
     */
    public Command<List<ReceivedByAddressResponse>> listReceivedByAddressCommand(int minimumAmountOfConfirmations) {
        return new CommandImpl<>(invoker, ReceivedByAddressResponse.class, "listreceivedbyaddress", minimumAmountOfConfirmations);
    }

    /**
     * Retrieves the transactions in the wallet, limiting to the first 10 transactions.
     */
    public Command<List<TransactionsResponse>> listTransactionsCommand() {
        return new CommandImpl<>(invoker, TransactionsResponse.class, "listtransactions");
    }

    /**
     * Retrieves the most recent transactions in the wallet for the account with the given account name, limiting to the first 10 transactions.
     */
    public Command<List<TransactionsResponse>> listTransactionsCommand(String account) {
        return listTransactionsCommand(account, 10);
    }

    /**
     * Retrieves the most recent transactions in the wallet for the account with the given account name, limiting to the first {count} transactions.
     */
    public Command<List<TransactionsResponse>> listTransactionsCommand(String account, int count) {
        return new CommandImpl<>(invoker, TransactionsResponse.class, "listtransactions", account, count);
    }

    /**
     * Retrieves the most recent transactions in the wallet for the account with the given account name, skipping {from} transactions, limiting to {count} transactions.
     */
    public Command<List<TransactionsResponse>> listTransactionsCommand(String account, int count, int from) {
        return new CommandImpl<>(invoker, TransactionsResponse.class, "listtransactions", account, count, from);
    }

    /**
     * Retrieves the unspent transaction outputs for which the confirmations are between 1 and 9999999.
     */
    public Command<List<UnspentResponse>> listUnspentCommand() {
        return listUnspentCommand(1, 9999999);
    }

    /**
     * Retrieves the unspent transaction outputs for which the confirmations are between the given {minConfirmations} and {maxConfirmations}.
     */
    public Command<List<UnspentResponse>> listUnspentCommand(int minConfirmations, int maxConfirmations) {
        return new CommandImpl<>(invoker, UnspentResponse.class, "listunspent");
    }

    /**
     * Locks the wallet. Returning <null> if successful.
     */
    public Command<Void> lockWalletCommand() {
        return new CommandImpl<>(invoker, Void.class, "walletlock");
    }

    /**
     * Sends a given amount to the given recipient address.
     * Returning the transactionId of the sent transaction if successful
     */
    public Command<String> sendToAddressCommand(String recipientAddress, BigDecimal amount) {
        return new CommandImpl<>(invoker, String.class, "sendtoaddress", recipientAddress, amount);
    }

    /**
     * Sends a given amount to the given recipient address. The given {comment} and {commentTo} will be stored locally and don't become part of the blockchain.
     * Returning the transactionId of the sent transaction if successful
     */
    public Command<String> sendToAddressCommand(String recipientAddress, BigDecimal amount, String comment, String commentTo) {
        return new CommandImpl<>(invoker, String.class, "sendtoaddress", recipientAddress, amount, comment, commentTo);
    }

    /**
     * Unlocks the wallet with the given passphrase, locking again after the given {timeout} in seconds. Returning <null> if successful.
     */
    public Command<Void> unlockWalletCommand(String passphrase, int timeout, boolean stakingOnly) {
        return new CommandImpl<>(invoker, Void.class, "walletpassphrase", passphrase, timeout, stakingOnly);
    }

}
