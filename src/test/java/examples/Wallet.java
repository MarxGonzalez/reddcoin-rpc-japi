package examples;

import com.reddcoin.rpc.japi.ReddcoinClient;
import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.commands.responses.*;
import com.reddcoin.rpc.japi.core.CommandResult;
import com.reddcoin.rpc.japi.http.ConnectionConfig;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Wallet {

    public static void main(String[] args) {
        ReddcoinClient reddcoinClient = ReddcoinClient.create(ConnectionConfig.builder().withUsernamePassword("developer", "developerpassword").build());

        Command<String> getAccountCommand = reddcoinClient.walletCommands().getAccountCommand("<reddcoin address>");
        printResult(getAccountCommand.execute());

        Command<String> getAccountAddressCommand = reddcoinClient.walletCommands().getAccountAddressCommand("<some account>");
        printResult(getAccountAddressCommand.execute());

        Command<List<String>> getAddressesByAccountCommand = reddcoinClient.walletCommands().getAddressesByAccountCommand("<some account>");
        printResult(getAddressesByAccountCommand.execute());

        Command<BigDecimal> getBalanceCommand = reddcoinClient.walletCommands().getBalanceCommand();
        printResult(getBalanceCommand.execute());

        Command<BigDecimal> getBalanceCommand2 = reddcoinClient.walletCommands().getBalanceCommand("<some account>");
        printResult(getBalanceCommand2.execute());

        Command<BigDecimal> getInterestCommand = reddcoinClient.walletCommands().getInterestCommand();
        printResult(getInterestCommand.execute());

        Command<RawTransactionResponse> getRawTransactionCommand = reddcoinClient.walletCommands().getRawTransactionCommand("<that long transaction id>");
        printResult(getRawTransactionCommand.execute());

        Command<BigDecimal> getReceivedByAccountCommand = reddcoinClient.walletCommands().getReceivedByAccountCommand("<some account>");
        printResult(getReceivedByAccountCommand.execute());

        Command<BigDecimal> getReceivedByAccountCommand2 = reddcoinClient.walletCommands().getReceivedByAddressCommand("<reddcoin address>");
        printResult(getReceivedByAccountCommand2.execute());

        Command<StakingInfoResponse> getStakingCommand = reddcoinClient.walletCommands().getStakingInfoCommand();
        printResult(getStakingCommand.execute());

        Command<TransactionResponse> getTransactionCommand = reddcoinClient.walletCommands().getTransactionCommand("<that long transaction id>");
        printResult(getTransactionCommand.execute());

        Command<BigDecimal> getUnconfirmedBalanceCommand = reddcoinClient.walletCommands().getUnconfirmedBalanceCommand();
        printResult(getUnconfirmedBalanceCommand.execute());

        Command<WalletResponse> getWalletCommand = reddcoinClient.walletCommands().getWalletInfoCommand();
        printResult(getWalletCommand.execute());

        Command<Map<String, BigDecimal>> listAccountsCommand = reddcoinClient.walletCommands().listAccountsCommand();
        printResult(listAccountsCommand.execute());

        Command<List<ReceivedByAccountResponse>> listReceivedByAccountCommand = reddcoinClient.walletCommands().listReceivedByAccountCommand();
        printResult(listReceivedByAccountCommand.execute());

        Command<List<ReceivedByAddressResponse>> listReceivedByAddressCommand = reddcoinClient.walletCommands().listReceivedByAddressCommand();
        printResult(listReceivedByAddressCommand.execute());

        Command<List<TransactionsResponse>> listTransactionsCommand = reddcoinClient.walletCommands().listTransactionsCommand("<some account>");
        printResult(listTransactionsCommand.execute());

        Command<List<UnspentResponse>> listUnspentCommand = reddcoinClient.walletCommands().listUnspentCommand();
        printResult(listUnspentCommand.execute());

        Command<Void> lockWalletCommand = reddcoinClient.walletCommands().lockWalletCommand();
        printResult(lockWalletCommand.execute());

        Command<Void> unlockWalletCommand = reddcoinClient.walletCommands().unlockWalletCommand("<PWD>", 1, false);
        printResult(unlockWalletCommand.execute());

        Command<String> sendToAddressCommand = reddcoinClient.walletCommands().sendToAddressCommand("<rcpt address>", BigDecimal.valueOf(101.00123456), "testing myself", "comment for receiver");
        printResult(sendToAddressCommand.execute());
    }

    private static void printResult(CommandResult<?> commandResult) {
        if (commandResult.isSuccess()) {
            System.out.println("command success -> " + commandResult.getResponse());
        } else {
            System.out.println("command error -> " + commandResult.getError());
        }
    }
}
