package com.proximety.jwt;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;

import static com.proximety.commons.Constants.*;

public class JWTValidator {

	public static void verifyToken(String token) throws Exception {
		Key publicKey = getPublicKey();
		verifyToken(token, publicKey);
	}

	private static Key getPublicKey() throws Exception {
		FileInputStream fis = new FileInputStream(KS_PATH);
		KeyStore ks = KeyStore.getInstance(KS_TYPE);
		ks.load(fis, KS_PASSWORD.toCharArray());
		Certificate cert = ks.getCertificate(KP_ALIAS);
		return cert.getPublicKey();
	}

	private static void verifyToken(String token, Key publicKey) throws Exception {
		JwtConsumer consumer = new JwtConsumerBuilder().setVerificationKey(publicKey).build();
		consumer.process(token);
	}
}
