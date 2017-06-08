package com.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by asehgal on 6/5/2017.
 */
public class InetAddressExample {

    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.yahoo.com");
            System.out.println(inetAddress.getHostAddress());


            InetAddress inetAddress1 = InetAddress.getByName("188.125.80.145");
            System.out.println("Host name is " + inetAddress1.getHostName());

            InetAddress inetAddress2 = InetAddress.getLocalHost();
            System.out.println("IP address of local host " + inetAddress2.getLocalHost());

            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            //System.out.println(inetAddress3az);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
