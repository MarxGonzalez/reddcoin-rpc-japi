package examples;

import com.reddcoin.rpc.japi.core.CommandResult;
import com.reddcoin.rpc.japi.http.ConnectionConfig;
import com.reddcoin.rpc.japi.ReddcoinClient;
import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.commands.responses.GetInfoResponse;

public class Environment {

    public static void main(String[] args) {
        ReddcoinClient reddcoinClient = ReddcoinClient.create(ConnectionConfig.builder().withUsernamePassword("developer", "developerpassword").build());

        Command<GetInfoResponse> getInfoCommand = reddcoinClient.environmentCommands().getInfoCommand();
        printResult(getInfoCommand.execute());

        Command<Void> pingCommand = reddcoinClient.environmentCommands().pingCommand();
        printResult(pingCommand.execute());
    }

    private static void printResult(CommandResult<?> commandResult) {
        if (commandResult.isSuccess()) {
            System.out.println("command success -> " + commandResult.getResponse());
        } else {
            System.out.println("command error -> " + commandResult.getError());
        }
    }
}
