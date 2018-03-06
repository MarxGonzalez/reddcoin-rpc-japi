# Reddcoin RPC Java Api #

This API implements most Reddcoin JSON-RPC commands.
The goal is to offer an API with a 'fluent style'. With the help of a decent IDE, the API is self-explaining.

If you are happy with it, feel free to donate to this Reddcoin address: `RZjC6eF849pXpzrQiHzG9BSDoGGVap2MfY`.

And of course: please create an issue or a PR when you've found a bug or have a feature request.

**[Next steps](#next-steps)**<br>
**[Installation](#installation)**<br>
**[Usage](#usage)**<br>

### Next Steps
* Provide support for connecting to an SSL-enabled RPC server
* Support for the `OkHttp` client when detected on classpath
* (Ongoing) support more commands

### Installation
First make sure a `reddcoin.conf` file is present in the Reddcoin data directory, next to the wallet file.
If not, take the file from this repository which provides basic settings, secured with a simple username and password.
*Make Sure* you use stronger credentials when running this in production!

Common locations are:
* Windows: `C:\Users\<user>\AppData\Roaming\Reddcoin`
* Linux: `/home/<user>/.reddcoin`
* Mac: `/Users/<user>/Library/Application Support/Reddcoin`

Then, restart your Reddcoin wallet or daemon, it should automatically pick up this file.

Secondly, ensure the JSOC-RPC server is actually running now on the target machine, check with `netstat -an | grep PORT` if the port is open (replace `PORT` with your actual port from `reddcoin.conf`).

See also [https://www.reddcointalk.org/topic/302/reddcoin-conf]

### Usage
The starting point for using the API is the `ReddcoinClient` class, it has static methods to initialize. 
From that point, just follow the return types. Or even better: use it in a fluent way.

The entire API follows one consistent pattern.

Example of *synchronous usage* for the `listaccounts` command:
```
CommandResult<Map<String, BigDecimal>> result = ReddcoinClient.create(ConnectionConfig.builder().withUsernamePassword("developer", "developerpassword").build())
    .walletCommands()
    .listAccountsCommand()
    .execute();

System.out.println(result.getResponse());
```

The same command is executed again in the example below, but in a really verbose way to show all involved types.
```
ReddcoinClient reddcoinClient = ReddcoinClient.create(ConnectionConfig.builder().withUsernamePassword("developer", "developerpassword").build());
WalletCommands walletCommands = reddcoinClient.walletCommands();
Command<Map<String, BigDecimal>> command = walletCommands.listAccountsCommand();
CommandResult<Map<String, BigDecimal>> result = command.execute();
Map<String, BigDecimal> response = result.getResponse();
System.out.println(response);
```

*Asynchronous usage* uses the same pattern, but uses the `executeAsync` method which returns a `CompletableFuture<T>`:
```
ReddcoinClient.create(ConnectionConfig.builder().withUsernamePassword("developer", "developerpassword").build())
    .walletCommands()
    .listAccountsCommand()
    .executeAsync()
    .thenAccept(result -> System.out.println(result.getResponse()));
```

Every command returns a `CommandResult<T>` which is basically a wrapper around the actual command-response and errors which might have happened.