package com.reddcoin.rpc.japi.http;

/**
 * Provides all the
 */
public class ConnectionConfig {

    private final String host;
    private final int port;

    private final String username;
    private final String password;

    private ConnectionConfig(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String host = "localhost";
        private int port = 45333;

        private String username;
        private String password;

        Builder() {
            //should not be instantiated directly
        }

        public Builder withHost(String host) {
            this.host = host;
            return this;
        }

        public Builder withPort(int port) {
            this.port = port;
            return this;
        }

        public Builder withUsernamePassword(String username, String password) {
            this.username = username;
            this.password = password;
            return this;
        }

        public ConnectionConfig build() {
            return new ConnectionConfig(host, port, username, password);
        }
    }

    String getHost() {
        return host;
    }

    int getPort() {
        return port;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
