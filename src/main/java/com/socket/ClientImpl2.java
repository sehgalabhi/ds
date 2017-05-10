package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by asehgal on 5/10/2017.
 */
public class ClientImpl2 {

    public static void main(String[] args) throws IOException {
        if (null == args[0] || null == args[1]) {
            throw new IllegalStateException("No hostanme or  port specified");
        }

        String hostName = args[0];
        int port = Integer.parseInt(args[1]);

        try (Socket socket = new Socket(hostName, port);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))

        ) {
            String userInput, serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println("serverResponse" + serverResponse);

                userInput = stdIn.readLine();
                if (userInput != null) {
                    System.out.println("Client :" + userInput);
                    printWriter.println(userInput);
                }


            }
        }


    }
}
