package com.jwe;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;
import junit.framework.TestCase;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class JWEPayloadsWithSharedKeyAESGCM128 extends TestCase {

    public void test() throws NoSuchAlgorithmException, JOSEException, ParseException {


        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        JWEHeader jweHeader = new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A128GCM);

        Payload payload = new Payload("Hello world");

        JWEObject jweObject = new JWEObject(jweHeader, payload);
        jweObject.encrypt(new DirectEncrypter(secretKey));
        String serialize = jweObject.serialize();
        System.out.println(serialize);

        JWEObject parse = JWEObject.parse(serialize);
        jweObject.decrypt(new DirectDecrypter(secretKey));

        payload = jweObject.getPayload();
        assertEquals("Hello world", payload.toString());


    }


}
