package com.jfsfeb.airlinereservationsystemjdbc.factory;

import com.jfsfeb.airlinereservationsystemjdbc.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemjdbc.dao.AdminDAOJDBCImpl;
import com.jfsfeb.airlinereservationsystemjdbc.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemjdbc.dao.UserDAOJDBCImple;
import com.jfsfeb.airlinereservationsystemjdbc.service.AdminService;
import com.jfsfeb.airlinereservationsystemjdbc.service.AdminServiceJDBCImpl;
import com.jfsfeb.airlinereservationsystemjdbc.service.UserService;
import com.jfsfeb.airlinereservationsystemjdbc.service.UserServiceJDBCImpl;

public class AirlineFactory {
	private AirlineFactory() {
		
	}
    public static AdminDAO getAdminDAOImplInstance() {
    	AdminDAO admindao=new AdminDAOJDBCImpl();
    	return admindao;
    }
    public static UserDAO getUserDAOImplInstance() {
    	UserDAO userdao=new UserDAOJDBCImple();
    	return userdao;
    }
    public static AdminService getAdminServiceImplInstance() {
    	AdminService adminService=new AdminServiceJDBCImpl();
    	return adminService;
    }
    public static UserService getUserServiceImplInstance() {
    	UserService userService=new UserServiceJDBCImpl();
    	return userService;
    }
}
