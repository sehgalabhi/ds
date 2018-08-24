package com.jws.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.text.ParseException;

public class JWSJWSTWithRSA2048WithSHA256 extends TestCase{

    public void test() throws JOSEException, ParseException {
        RSAKey rsaKey = ((RSAKeyGenerator) new RSAKeyGenerator(2048).keyID("123")).generate();

        RSAKey rsaPublicJWK = rsaKey.toPublicJWK();

        JWSSigner jwsSigner = new RSASSASigner(rsaKey);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder().issuer("iss").subject("sub").build();
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), jwtClaimsSet);

        signedJWT.sign(jwsSigner);
        String serialize = signedJWT.serialize();
        System.out.println(serialize);

        JWSVerifier jwsVerifier = new RSASSAVerifier(rsaPublicJWK);
        SignedJWT parse = SignedJWT.parse(serialize);

        Assert.assertTrue(parse.verify(jwsVerifier));
        Assert.assertEquals("iss", parse.getJWTClaimsSet().getIssuer());
        Assert.assertEquals("sub", parse.getJWTClaimsSet().getSubject());
    }
}
