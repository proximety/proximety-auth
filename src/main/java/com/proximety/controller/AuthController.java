package com.proximety.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proximety.dto.UpdateUserInfoRequestDTO;
import com.proximety.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;

	@PostMapping("/sendotp")
	public void validateOT(String phoneNumber) {
		authService.sendOTP(phoneNumber);
	}
	
	@PostMapping("/verifyotp")
	public void verifyOTP(HttpServletResponse response, String phoneNumber, String otp) {
		String token = authService.verifyOTP(phoneNumber, otp);
		response.setHeader("Token", token);
	}
	
	@PutMapping("/updateuserinfo")
	public UpdateUserInfoRequestDTO updateUserInfo(HttpServletResponse response, @RequestBody UpdateUserInfoRequestDTO requestDTO) {
		authService.updateUserInfo(requestDTO);
		return requestDTO;
	}
}
