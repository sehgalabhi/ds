package com.jwe;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.text.ParseException;

public class JWEJWTWithRSAEncryption extends TestCase {

    public void test() throws JOSEException, ParseException {

        RSAKey rsaKey = ((RSAKeyGenerator) new RSAKeyGenerator(2048).keyID("123")).generate();
        RSAKey rsaPublicKey = rsaKey.toPublicJWK();

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder().subject("sub").issuer("iss").build();
        System.out.println(jwtClaimsSet.toJSONObject().toString());

        JWEHeader jweHeader = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);
        EncryptedJWT encryptedJWT = new EncryptedJWT(jweHeader, jwtClaimsSet);

        JWEEncrypter jweEncrypter = new RSAEncrypter(rsaPublicKey);
        encryptedJWT.encrypt(jweEncrypter);
        String serialize = encryptedJWT.serialize();
        System.out.println(serialize);
        EncryptedJWT parse = EncryptedJWT.parse(serialize);
        JWEDecrypter jweDecrypter = new RSADecrypter(rsaKey);

        parse.decrypt(jweDecrypter);
        JWTClaimsSet jwtClaimsSet1 = parse.getJWTClaimsSet();
        Assert.assertEquals("sub", jwtClaimsSet1.getSubject());
        Assert.assertEquals("iss", jwtClaimsSet1.getIssuer());




    }
}
