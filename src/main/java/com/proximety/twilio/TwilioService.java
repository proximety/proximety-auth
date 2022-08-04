package com.proximety.twilio;

import org.springframework.web.client.RestClientException;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

import static com.proximety.commons.Constants.*;

public class TwilioService {

	public static void sendOTP(String phoneNumber) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		phoneNumber = PHONE_PREFIX + phoneNumber;

		Verification verification = Verification.creator(SERVICE_ID, phoneNumber, MEDIUM).create();

		String status = verification.getStatus();
		System.out.println("Status: " + status);
		if(!STATUS_PENDING.equals(status)) {
			throw new RestClientException("Failed to send OTP.");
		}
	}

	public static void verifyOTP(String phoneNumber, String otp) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		phoneNumber = PHONE_PREFIX + phoneNumber;

		VerificationCheck verificationCheck = VerificationCheck.creator(SERVICE_ID)
				.setTo(phoneNumber)
				.setCode(otp)
				.create();
		
		String status = verificationCheck.getStatus();
		System.out.println("Status: " + status);
		if(!STATUS_APPROVED.equals(status)) {
			throw new RestClientException("OTP Verificatiion failed.");
		}
	}
}
