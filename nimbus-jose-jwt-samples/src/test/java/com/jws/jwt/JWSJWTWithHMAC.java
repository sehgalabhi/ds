package com.jws.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Date;

public class JWSJWTWithHMAC extends TestCase {

    public void test() throws JOSEException, ParseException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] sharedSecret = new byte[32];
        secureRandom.nextBytes(sharedSecret);

        JWSSigner jwsSigner = new MACSigner(sharedSecret);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder().subject("alice").issuer("https://c2id.com").
                expirationTime(new Date(new Date().getTime() + 60 * 1000)).build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), jwtClaimsSet);

        signedJWT.sign(jwsSigner);
        String serialize = signedJWT.serialize();
        System.out.println(serialize);

        SignedJWT parse = SignedJWT.parse(serialize);
        JWSVerifier jwsVerifier = new MACVerifier(sharedSecret);

        Assert.assertTrue(parse.verify(jwsVerifier));
        JWTClaimsSet jwtClaimsSet1 = parse.getJWTClaimsSet();
        assertEquals("alice", jwtClaimsSet1.getSubject());
        assertEquals("https://c2id.com", jwtClaimsSet1.getIssuer());
        assertTrue(new Date().before(jwtClaimsSet1.getExpirationTime()));


    }
}
