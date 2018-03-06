package examples;

import com.reddcoin.rpc.japi.core.CommandResult;
import com.reddcoin.rpc.japi.http.ConnectionConfig;
import com.reddcoin.rpc.japi.ReddcoinClient;
import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.commands.responses.MiningInfoResponse;

public class Mining {

    public static void main(String[] args) {
        ReddcoinClient reddcoinClient = ReddcoinClient.create(ConnectionConfig.builder().withUsernamePassword("developer", "developerpassword").build());

        Command<MiningInfoResponse> miningInfoCommand = reddcoinClient.miningCommands().getMiningInfoCommand();
        printResult(miningInfoCommand.execute());

        Command<Long> networkHashesPerSecondCommand = reddcoinClient.miningCommands().getNetworkHashesPerSecondCommand();
        printResult(networkHashesPerSecondCommand.execute());
    }

    private static void printResult(CommandResult<?> commandResult) {
        if (commandResult.isSuccess()) {
            System.out.println("command success -> " + commandResult.getResponse());
        } else {
            System.out.println("command error -> " + commandResult.getError());
        }
    }
}
