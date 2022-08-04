package com.proximety.commons;

public class Constants {

	//JWT constants
	public static final float TOKEN_EXPIRY = 5 * 24 * 60; // 5 days
	public static final String ISSUER = "proximety";
	public static final String KP_ALIAS = "dev.proximety"; 
	public static final String KS_TYPE = "JKS";
	public static final String SIGNING_ALGORITHM = "RS256";
	public static final String KS_PATH = "src/main/resources/proximety.jks";
	
	public static final String KS_PASSWORD = System.getenv("KS_PASSWORD");
	public static final String KP_PASSWORD = System.getenv("KP_PASSWORD");
	
	//Twilio
	public static final String ACCOUNT_SID = System.getenv("ACCOUNT_SID");
	public static final String AUTH_TOKEN = System.getenv("AUTH_TOKEN");
	public static final String SERVICE_ID = System.getenv("SERVICE_ID");
	public static final String PHONE_PREFIX = "+91";
	public static final String MEDIUM = "sms";
	public static final String STATUS_PENDING = "pending";
	public static final String STATUS_APPROVED = "approved";
	
}
