package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

import lombok.Data;
@Data
@SuppressWarnings("serial")
public class AdminInfo implements Serializable{
	private int id = (int)Math.random();
	private String name;
	private String emailId;
	private String password;
	private long mobileNo;
	public AdminInfo(int id, String name, String emailId, String password, long mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
	}
	public AdminInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
}
