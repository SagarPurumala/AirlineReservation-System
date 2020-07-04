package com.capgemini.airlinereservationsystem.dao;

import com.capgemini.airlinereservationsystem.beans.UserBean;

public interface UserDAO {
	
	public boolean registerUser(UserBean userBean);
	
	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);

}
