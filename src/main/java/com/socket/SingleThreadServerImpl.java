package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by asehgal on 5/10/2017.
 */
public class SingleThreadServerImpl {

    public static void main(String[] args) throws IOException {

        if (null == args[0] || "".equals(args[0])) {
            throw new IllegalStateException("No port specified");
        }

        int portNumber = Integer.parseInt(args[0]);
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))

        ) {
            String inputLine, outputLine;

            KnockKnockProtocol knockKnockProtocol = new KnockKnockProtocol();

            printWriter.println(knockKnockProtocol.processInput(null));

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                outputLine = knockKnockProtocol.processInput(inputLine);
                printWriter.println(outputLine);
            }
        }

    }
}
