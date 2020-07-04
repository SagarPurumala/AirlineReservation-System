package com.jfsfeb.airlinereservationsystemcollection.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@SuppressWarnings("serial")
public class UserInfo implements Serializable {
	private int userId;
	private String userName;
	private String emailId;
	@ToString.Exclude
	private String password;
	private long mobileNumber;

}
