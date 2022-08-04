package com.proximety.dto;

public class UpdateUserInfoRequestDTO {
	
	private String fullName;
	private String gender;
	private String email;
	private String dob;
	private String referralCode;
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getReferralCode() {
		return referralCode;
	}
	
	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

}
