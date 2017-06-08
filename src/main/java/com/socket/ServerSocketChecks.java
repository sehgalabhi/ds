package com.socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by asehgal on 6/2/2017.
 */
public class ServerSocketChecks {

    public static void main(String[] args) {
        new ServerSocketChecks().test();
    }

    private void test() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(3000);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
