package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
}