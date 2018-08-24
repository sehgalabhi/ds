package com.jwe;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import junit.framework.TestCase;

import java.text.ParseException;

public class NestedSignedAndEncryptedJWT extends TestCase {

    public void test() throws JOSEException, ParseException {
        RSAKey senderJWK = ((RSAKeyGenerator) ((RSAKeyGenerator) new RSAKeyGenerator(2048).keyID("123")).keyUse(KeyUse.SIGNATURE)).generate();
        RSAKey senderPublicJWK = senderJWK.toPublicJWK();

        RSAKey recipientJWK = ((RSAKeyGenerator) ((RSAKeyGenerator) new RSAKeyGenerator(2048).keyID("456")).keyUse(KeyUse.ENCRYPTION)).generate();
        RSAKey recipientPublicJWK = recipientJWK.toPublicJWK();


        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder().subject("sub").issuer("iss").build();
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), jwtClaimsSet);
        signedJWT.sign(new RSASSASigner(senderJWK));

        JWEObject jweObject = new JWEObject(new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A256GCM), new Payload(signedJWT));
        jweObject.encrypt(new RSAEncrypter(recipientPublicJWK));

        String serialize = jweObject.serialize();

        System.out.println(serialize);


        JWEObject jweObjectParse = JWEObject.parse(serialize);
        jweObjectParse.decrypt(new RSADecrypter(recipientJWK));

        SignedJWT signedJWTRecieved = jweObjectParse.getPayload().toSignedJWT();
        signedJWTRecieved.verify(new RSASSAVerifier(senderPublicJWK));

        assertEquals("sub", signedJWTRecieved.getJWTClaimsSet().getSubject());


    }
}
