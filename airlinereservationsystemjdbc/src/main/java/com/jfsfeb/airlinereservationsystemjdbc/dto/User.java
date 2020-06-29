package com.jfsfeb.airlinereservationsystemjdbc.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@SuppressWarnings("serial")
@Data
public class User implements Serializable{
	
    private int id;
    private String name;
    private String emailId;
    private long mobileNumber;
    @ToString.Exclude
    private String password;
    private String role;

}
