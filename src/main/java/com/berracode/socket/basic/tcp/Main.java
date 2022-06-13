package com.berracode.socket.basic.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static int PORT = 9090;

    public static void main(String[] args) {
        Socket socket;

        BufferedReader inputStream;
        DataOutputStream outputStream;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Waiting connections...");
            socket = serverSocket.accept();
            System.out.println("A client has connected");

            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Verifying connection...");

            outputStream.writeUTF("Success connection!");

            String newMessage = inputStream.readLine();

            System.out.println("Message from client: " + newMessage);

            outputStream.writeUTF("We receive your message!\n");

            outputStream.writeUTF("Thanks for your message!\n");

            System.out.println("Closing connection...");

            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
