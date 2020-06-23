package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

import lombok.Data;
@Data
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
		
	}
	

}
