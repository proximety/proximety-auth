package com.proximety.jwt;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.UUID;

import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;

import com.proximety.commons.UserRole;

import static com.proximety.commons.Constants.*;

public class JWTGenerator {

	public static String generateToken(String userId) throws Exception {
		JwtClaims claims = getClaims(userId);
		Key privateKey = getPrivateKey();
		return generateToken(claims, privateKey);
	}

	private static JwtClaims getClaims(String userId) {
		JwtClaims claims = new JwtClaims();
		claims.setJwtId(UUID.randomUUID().toString());
		claims.setIssuedAt(NumericDate.now());
		claims.setExpirationTimeMinutesInTheFuture(TOKEN_EXPIRY); 
		claims.setIssuer(ISSUER);
		claims.setSubject(userId); // user id is the subject
		claims.setClaim("role", UserRole.CUSTOMER.toString().toLowerCase());
		return claims;
	}

	private static Key getPrivateKey() throws Exception {
		FileInputStream fis = new FileInputStream(KS_PATH);
		KeyStore ks = KeyStore.getInstance(KS_TYPE);
		ks.load(fis, KS_PASSWORD.toCharArray());
		return ks.getKey(KP_ALIAS, KP_PASSWORD.toCharArray());
	}

	private static String generateToken(JwtClaims claims, Key privateKey) throws Exception {
		JsonWebSignature jws = new JsonWebSignature();
		jws.setPayload(claims.toJson());
		jws.setAlgorithmHeaderValue(SIGNING_ALGORITHM);
		jws.setKey(privateKey);
		return jws.getCompactSerialization();
	}
}
