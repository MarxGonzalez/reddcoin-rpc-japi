package examples;

import com.reddcoin.rpc.japi.core.CommandResult;
import com.reddcoin.rpc.japi.http.ConnectionConfig;
import com.reddcoin.rpc.japi.ReddcoinClient;
import com.reddcoin.rpc.japi.core.Command;
import com.reddcoin.rpc.japi.commands.responses.NetTotalResponse;
import com.reddcoin.rpc.japi.commands.responses.NetworkInfoResponse;
import com.reddcoin.rpc.japi.commands.responses.PeerInfoResponse;

import java.util.List;

public class Network {

    public static void main(String[] args) {
        ReddcoinClient reddcoinClient = ReddcoinClient.create(ConnectionConfig.builder().withUsernamePassword("developer", "developerpassword").build());

        Command<Long> getConnectionCountCommand = reddcoinClient.networkCommands().getConnectionCountCommand();
        printResult(getConnectionCountCommand.execute());

        Command<NetworkInfoResponse> getNetworkInfoCommand = reddcoinClient.networkCommands().getNetworkInfoCommand();
        printResult(getNetworkInfoCommand.execute());

        Command<NetTotalResponse> getNetworkTotalsCommand = reddcoinClient.networkCommands().getNetworkTotalsCommand();
        printResult(getNetworkTotalsCommand.execute());

        Command<List<PeerInfoResponse>> getPeerInfoCommand = reddcoinClient.networkCommands().getPeerInfoCommand();
        printResult(getPeerInfoCommand.execute());
    }

    private static void printResult(CommandResult<?> commandResult) {
        if (commandResult.isSuccess()) {
            System.out.println("command success -> " + commandResult.getResponse());
        } else {
            System.out.println("command error -> " + commandResult.getError());
        }
    }
}
