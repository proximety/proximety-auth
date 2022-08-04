package com.proximety.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.proximety.dto.UpdateUserInfoRequestDTO;
import com.proximety.jwt.JWTGenerator;
import com.proximety.twilio.TwilioService;

@Component
public class AuthService {

	public void sendOTP(String phoneNumber) {
		TwilioService.sendOTP(phoneNumber);
	}

	public String verifyOTP(String phoneNumber, String otp) {
		try {
			TwilioService.verifyOTP(phoneNumber, otp);
			//TODO - create user in DB
			String userId = "123"; //primary key of the user created
			String token = JWTGenerator.generateToken(userId);
			return token;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestClientException("OTP Verification failed.");
		}
	}

	public String updateUserInfo(UpdateUserInfoRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
