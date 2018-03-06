package com.reddcoin.rpc.japi.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class NativeHttpClient implements HttpClient {

    private final URL url;
    private final ConnectionConfig connectionConfig;

    public NativeHttpClient(ConnectionConfig connectionConfig) {
        this.connectionConfig = connectionConfig;
        this.url = createTargetUrl(connectionConfig.getHost(), connectionConfig.getPort());
    }

    private URL createTargetUrl(String host, int port) {
        String rawUrl = String.format("http://%s:%d", host, port);

        try {
            return new URL(rawUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not parse URL: " + rawUrl, e);
        }
    }

    @Override
    public String sendAndReceive(String request) {
        HttpURLConnection conn = createAndPrepareConnection();

        try {
            writeRequest(request, conn);

            return readResponse(conn);
        } finally {
            conn.disconnect();
        }
    }

    @Override
    public CompletableFuture<String> sendAndReceiveAsync(String request) {
        return CompletableFuture.supplyAsync(() -> sendAndReceive(request));
    }

    private void writeRequest(String request, HttpURLConnection conn) {
        OutputStream outputStream;
        try {
            outputStream = conn.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException("Could not get output stream", e);
        }


        try {
            outputStream.write(request.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException("Could not get write request to outputstream", e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                //ignore
            }
        }
    }

    private String readResponse(HttpURLConnection conn) {
        InputStream inputStream;
        try {
            inputStream = conn.getInputStream();
        } catch (IOException exception) {
            inputStream = conn.getErrorStream();
        }

        String text;
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                //ignore
            }
        }

        return text;
    }

    private HttpURLConnection createAndPrepareConnection() {
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            if (connectionConfig.getUsername() != null) {
                byte[] usernamePassword = (connectionConfig.getUsername() + ":" + connectionConfig.getPassword()).getBytes("UTF-8");
                conn.setRequestProperty("Authorization", "Basic " + new String(Base64.getEncoder().encode(usernamePassword)));
            }
            conn.setRequestProperty("Content-Type", "application/json-rpc");
            return conn;
        } catch (IOException e) {
            throw new RuntimeException("Cannot create URL connection to " + this.url, e);
        }
    }
}