package com.capgemini.airlinereservationsystem.service;

import com.capgemini.airlinereservationsystem.beans.UserBean;

public interface UserService {

	public boolean registerUser(UserBean userBean);

	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);

}
