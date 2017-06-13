package com.datatype;

/**
 * Created by asehgal on 6/13/2017.
 */
public class ByteValueToHex {
    public static void main(String[] args) {
        new ByteValueToHex().test();
    }

    private void test() {
        byte[] bytes = {115, 13, 108, 8, -1};
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes
                ) {
            stringBuilder.append(String.format("%02X ", b));
        }
        System.out.println(stringBuilder.toString());
    }
}
