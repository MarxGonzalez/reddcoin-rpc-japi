package examples;

import com.reddcoin.rpc.japi.core.CommandResult;
import com.reddcoin.rpc.japi.http.ConnectionConfig;
import com.reddcoin.rpc.japi.ReddcoinClient;
import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.commands.responses.BlockResponse;
import com.reddcoin.rpc.japi.commands.responses.BlockchainInfoResponse;
import com.reddcoin.rpc.japi.commands.responses.TransactionOutputResponse;
import com.reddcoin.rpc.japi.commands.responses.TransactionOutputSetInfoResponse;

public class Blockchain {

    public static void main(String[] args) {
        ReddcoinClient reddcoinClient = ReddcoinClient.create(ConnectionConfig.builder().withUsernamePassword("developer", "developerpassword").build());

        Command<BlockchainInfoResponse> blockchainInfoCommand = reddcoinClient.blockchainCommands().getBlockchainInfoCommand();
        printResult(blockchainInfoCommand.execute());

        Command<Long> blockCountCommand = reddcoinClient.blockchainCommands().blockCountCommand();
        printResult(blockCountCommand.execute());

        Command<BlockResponse> blockCommand = reddcoinClient.blockchainCommands().getBlockCommand("ebe2acbb6ba325d9992a3a22ab9896fb2342a261a49ec785fc4b3c9b82ad912a");
        printResult(blockCommand.execute());

        Command<String> blockHashCommand = reddcoinClient.blockchainCommands().getBlockHashCommand(1);
        printResult(blockHashCommand.execute());

        Command<String> bestBlockHashCommand = reddcoinClient.blockchainCommands().getBestBlockHashCommand();
        printResult(bestBlockHashCommand.execute());

        Command<TransactionOutputResponse> transactionOutputCommand = reddcoinClient.blockchainCommands().getTransactionOutputCommand("96d442c42beb1c939fa7495de2a91dbdb3bba9545a2025abaed84eab24a1923e", 0, false);
        printResult(transactionOutputCommand.execute());

        Command<TransactionOutputSetInfoResponse> transactionOutputSetInfoCommand = reddcoinClient.blockchainCommands().getTransactionOutputSetInfoCommand();
        printResult(transactionOutputSetInfoCommand.execute());
    }

    private static void printResult(CommandResult<?> commandResult) {
        if (commandResult.isSuccess()) {
            System.out.println("command success -> " + commandResult.getResponse());
        } else {
            System.out.println("command error -> " + commandResult.getError());
        }
    }
}
