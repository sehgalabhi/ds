package com.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by asehgal on 5/10/2017.
 */
public class MultipleThreadServerImpl {

    public static void main(String[] args) throws IOException {

        if (null == args[0] || "".equals(args[0])) {
            throw new IllegalStateException("No port specified");
        }

        int portNumber = Integer.parseInt(args[0]);
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber)
        ) {

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket.getLocalSocketAddress());
                System.out.println(clientSocket.getLocalPort());
                System.out.println(clientSocket.getRemoteSocketAddress());
                new KKMultiServerThread(clientSocket).start();
            }
        }

    }
}
