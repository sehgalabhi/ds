package com.bytes;


public class BytesInString {
    public static void main(String[] args) {
        new BytesInString().test();
    }

    private void test() {


        int val = 0x0A;
        System.out.println(val);

        byte a = (byte) -127;
        System.out.println(a);

        byte b = 'Z';

        String testString = "HelloWorld";
        byte[] bytesOrig = testString.getBytes();


    }
}
