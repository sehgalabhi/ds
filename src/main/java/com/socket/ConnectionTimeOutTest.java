package com.socket;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionTimeOutTest {

    public static void main(String[] args) throws IOException {
        new ConnectionTimeOutTest().test();

    }

    private void test() throws IOException {
        URL url = new URL("http://somehost.com");
        URLConnection con = url.openConnection();

//        con.setConnectTimeout(0);
//
        con.setUseCaches(false);
        con.setConnectTimeout(100000);
////        System.out.println(con.getConnectTimeout());
        con.connect();

    }
}
