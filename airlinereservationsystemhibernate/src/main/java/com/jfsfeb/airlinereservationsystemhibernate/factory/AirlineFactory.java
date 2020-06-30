package com.jfsfeb.airlinereservationsystemhibernate.factory;

import com.jfsfeb.airlinereservationsystemhibernate.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemhibernate.dao.AdminDAOJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemhibernate.dao.UserDAOJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.service.AdminSeriveJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.service.AdminService;
import com.jfsfeb.airlinereservationsystemhibernate.service.UserService;
import com.jfsfeb.airlinereservationsystemhibernate.service.UserServiceJPAImpl;

public class AirlineFactory {
	private AirlineFactory() {
		
	}
    public static AdminDAO getAdminDAOImplInstance() {
    	AdminDAO admindao=new AdminDAOJPAImpl();
    	return admindao;
    }
    public static UserDAO getUserDAOImplInstance() {
    	UserDAO userdao=new UserDAOJPAImpl();
    	return userdao;
    }
    public static AdminService getAdminServiceImplInstance() {
    	AdminService adminService=new AdminSeriveJPAImpl();
    	return adminService;
    }
    public static UserService getUserServiceImplInstance() {
    	UserService userService=new UserServiceJPAImpl();
    	return userService;
    }

}
