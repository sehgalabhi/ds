package com.bytes;

import com.bellid.util.StringUtilities;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BytesInString {
    public static void main(String[] args) {
        new BytesInString().test();
    }

    private void test() {
        try {

            String testString = "HelloWorld";
            byte[] bytesOrig = testString.getBytes();

            String s = StringUtilities.toHexString(testString.getBytes());
            System.out.println(s);

            byte[] bytes = StringUtilities.fromHexString(s);
            String result = new String(bytes);
            System.out.println(result);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] digest = messageDigest.digest(testString.getBytes());


            byte[] bytes1 = testString.getBytes(Charset.forName("UTF-16"));
            String s1 = StringUtilities.toHexString(testString.getBytes(Charset.forName("UTF-16")));
            System.out.println(s1);



        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
