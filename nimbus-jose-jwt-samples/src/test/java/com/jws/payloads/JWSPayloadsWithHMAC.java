package com.jws.payloads;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.security.SecureRandom;
import java.text.ParseException;

/**
 * Create and verify JWS encoded object with Hash based message authentication code
 */
public class JWSPayloadsWithHMAC extends TestCase {


    public void test1() throws JOSEException, ParseException {
        byte[] sharedSecret = createSharedSecret();

        String s = signAndSerialize(sharedSecret);
        System.out.println(s);

        JWSObject jwsObject = verifyParsedObject(sharedSecret, s);

        assertEquals("Hello, world", jwsObject.getPayload().toString());

    }

    private JWSObject verifyParsedObject(byte[] sharedSecret, String s) throws ParseException, JOSEException {
        JWSObject jwsObject = JWSObject.parse(s);
        JWSVerifier jwsVerifier = new MACVerifier(sharedSecret);
        Assert.assertTrue(jwsObject.verify(jwsVerifier));
        return jwsObject;
    }

    private String signAndSerialize(byte[] sharedSecret) throws JOSEException {
        JWSSigner jwsSigner = new MACSigner(sharedSecret);

        JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload("Hello, world"));
        jwsObject.sign(jwsSigner);

        String s = jwsObject.serialize();
        return s;
    }

    private byte[] createSharedSecret() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] sharedSecret = new byte[32];
        secureRandom.nextBytes(sharedSecret);
        return sharedSecret;
    }
}
