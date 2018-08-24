package com.jws.payloads;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import junit.framework.TestCase;

import java.security.interfaces.ECPublicKey;

public class JWSPayloadsWithEllipticCurveP256DSAWIthSHA256 extends TestCase {

    public void test() throws JOSEException {
        ECKey ecJWS = ((ECKeyGenerator) new ECKeyGenerator(Curve.P_256).keyID("123")).generate();

        JWSSigner jwsSigner = new ECDSASigner(ecJWS);

        JWSObject jwsObject = new JWSObject(new JWSHeader.Builder(JWSAlgorithm.ES256).keyID("123").build(), new Payload("Elliptic Curve"));
        jwsObject.sign(jwsSigner);

        String serialize = jwsObject.serialize();
        System.out.println(serialize);

        ECPublicKey ecPublicKey = ecJWS.toECPublicKey();
        JWSVerifier jwsVerifier = new ECDSAVerifier(ecPublicKey);

        assertTrue(jwsObject.verify(jwsVerifier));
        assertEquals("Elliptic Curve", jwsObject.getPayload().toString());


    }
}
