package com.bytes;

import com.bellid.util.StringUtilities;

import java.math.BigDecimal;
import java.nio.charset.Charset;

import static com.bellid.util.StringUtilities.toHexString;

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

        final byte[] bytes1 = StringUtilities.toUtf8Bytes(lucID);

        System.out.println(toHexString(bytes1));

        String lucID1 ="1B";
        final byte[] bytes2 =  StringUtilities.fromHexString(lucID1);
//        final byte[] bytes2 = StringUtilities.toUtf8Bytes(lucID1);
        System.out.println(toHexString(bytes2));

        System.out.println(BigDecimal.ZERO);

        System.out.println((String) null);
        String hexString = "0101195F24031706305A0866666992804877205F3401014203415853";
        final byte[] bytes3 = StringUtilities.fromHexString(hexString);
        System.out.println(new String(bytes3, Charset.forName("UTF-8")));
        System.out.println(toHexString(bytes3));
    }
}
