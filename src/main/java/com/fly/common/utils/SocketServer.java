package com.fly.common.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        int port = 9999;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("SocketServer started, listening on port " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
            
            // 输出流发送数据给客户端
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // 输入流读取客户端数据（可选，但为了演示不读）
            
            // 读取用户输入并发送
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            System.out.println("Enter messages to send to client (type 'exit' to quit):");
            while ((line = consoleReader.readLine()) != null) {
                if ("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server stopped.");
    }
}