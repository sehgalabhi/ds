package com.bytes;


/**
 * Created by asehgal on 12/13/2017.
 */
public class BytesConversion {

    public static void main(String[] args) {
        String example = "This is an example";
        byte[] bytes = example.getBytes();

        System.out.println("Text : " + example);
        System.out.println("Text [Byte Format] : " + bytes);
        System.out.println("Text [Byte Format] : " + bytes.toString());

        String s = new String(bytes);
        System.out.println("Text Decryted : " + s);

        String lucID = "M";

    }
}
