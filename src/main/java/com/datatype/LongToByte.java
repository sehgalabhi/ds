package com.datatype;

import java.io.ByteArrayOutputStream;

/**
 * Created by asehgal on 6/28/2017.
 */
public class LongToByte {

    public static void main(String[] args) {
        new LongToByte().test();
    }

    private void test() {
        long a = 1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.out.println(String.valueOf(a));

        System.out.println(Long.valueOf(a).toString().getBytes());

    }
}
