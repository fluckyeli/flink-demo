package com.fly.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;
        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server " + host + ":" + port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Connection closed by server.");
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}