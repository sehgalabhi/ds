package com.jws.payloads;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.Ed25519Signer;
import com.nimbusds.jose.crypto.Ed25519Verifier;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import com.nimbusds.jose.jwk.gen.OctetKeyPairGenerator;
import junit.framework.TestCase;

import java.text.ParseException;

public class JWSPayloadsWIthEdwardsCurveDSA25519 extends TestCase {

    public void test() throws JOSEException, ParseException {
        OctetKeyPair octetKeyPair = ((OctetKeyPairGenerator) new OctetKeyPairGenerator(Curve.Ed25519).keyID("123")).generate();
        JWSSigner jwsSigner = new Ed25519Signer(octetKeyPair);

        JWSObject jwsObject = new JWSObject(new JWSHeader.Builder(JWSAlgorithm.EdDSA).keyID("123").build(), new Payload("Crypto Edwards"));
        jwsObject.sign(jwsSigner);
        String serialize = jwsObject.serialize();
        System.out.println(serialize);

        OctetKeyPair publicJWK = octetKeyPair.toPublicJWK();
        JWSVerifier jwsVerifier = new Ed25519Verifier(publicJWK);
        jwsObject = JWSObject.parse(serialize);

        assertTrue(jwsObject.verify(jwsVerifier));
        assertEquals("Crypto Edwards", jwsObject.getPayload().toString());


    }
}
