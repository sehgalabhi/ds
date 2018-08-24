package com.jws.payloads;


import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.text.ParseException;

public class JWSPayloadsWithRSA2048WithSHA256 extends TestCase {

    /**
     * Signing is with private key
     */
    public void test() throws JOSEException, ParseException {

        RSAKey rsaJWK = ((RSAKeyGenerator) new RSAKeyGenerator(2048).keyID("123")).generate();

        JWSSigner jwsSigner = new RSASSASigner(rsaJWK);
        String serialize = sign(rsaJWK, jwsSigner);

        System.out.println(serialize);

        JWSObject jwsObject = JWSObject.parse(serialize);
        RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();
        JWSVerifier jwsVerifier = new RSASSAVerifier(rsaPublicJWK);
        Assert.assertTrue(jwsObject.verify(jwsVerifier));

        Assert.assertEquals("In RSA we trust", jwsObject.getPayload().toString());


    }

    private String sign(RSAKey rsaJWK, JWSSigner jwsSigner) throws JOSEException {
        JWSObject jwsObject = new JWSObject(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
                new Payload("In RSA we trust"));

        jwsObject.sign(jwsSigner);
        return jwsObject.serialize();
    }

}
