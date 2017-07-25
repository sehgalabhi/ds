package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by asehgal on 5/10/2017.
 */
public class ClientImplAndori {
    private final static String JSON_STRING_SUCCESS = "{transactionAmount: 400," +
            "otherAmount: 0," +
            "currencyCode: 840," +
            "transactionType: 1," +
            "unpredictableNumber: 11224455," +
            "cryptogramType: UCAF," +
            "transactionDate: {" +
            "year: 15," +
            "month: 7," +
            "day: 13" +
            "},countryCode: 840" +
            "}";

    public static void main(String[] args) throws IOException {
       /* if (null == args[0] || null == args[1]) {
            throw new IllegalStateException("No hostanme or  port specified");
        }*/

        String hostName = "10.6.4.249";
        int port = Integer.parseInt("3232");

        try (Socket socket = new Socket(hostName, port);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))

        ) {
            String userInput, serverResponse;
            printWriter.println(JSON_STRING_SUCCESS);
            while ((serverResponse = in.readLine()) != null) {
                System.out.println("serverResponse" + serverResponse);



            }
        }


    }
}
