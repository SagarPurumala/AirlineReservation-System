package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfo implements Serializable {
	private int userId;
	private String userName;
	private String emailId;
	private String password;
	private String mobileNumber;
	public UserInfo(int userId, String userName, String emailId, String password, String mobileNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}
	public UserInfo() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	

}
