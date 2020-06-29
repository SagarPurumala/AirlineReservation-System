package com.jfsfeb.airlinereservationsystem.factory;

import com.jfsfeb.airlinereservationsystem.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystem.dao.AdminDAOImple;
import com.jfsfeb.airlinereservationsystem.dao.UserDAO;
import com.jfsfeb.airlinereservationsystem.dao.UserDAOImple;
import com.jfsfeb.airlinereservationsystem.service.AdminService;
import com.jfsfeb.airlinereservationsystem.service.AdminServiceImple;
import com.jfsfeb.airlinereservationsystem.service.UserService;
import com.jfsfeb.airlinereservationsystem.service.UserServiceImple;

public class AirlineFactory {
	private AirlineFactory() {
		
	}
    public static AdminDAO getAdminDAOImplInstance() {
    	AdminDAO admindao=new AdminDAOImple();
    	return admindao;
    }
    public static UserDAO getUserDAOImplInstance() {
    	UserDAO userdao=new UserDAOImple();
    	return userdao;
    }
    public static AdminService getAdminServiceImplInstance() {
    	AdminService adminService=new AdminServiceImple();
    	return adminService;
    }
    public static UserService getUserServiceImplInstance() {
    	UserService userService=new UserServiceImple();
    	return userService;
    }
    
}
