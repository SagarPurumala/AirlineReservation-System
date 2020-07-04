package com.jfsfeb.airlinereservationsystemcollection.factory;

import com.jfsfeb.airlinereservationsystemcollection.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemcollection.dao.AdminDAOImple;
import com.jfsfeb.airlinereservationsystemcollection.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemcollection.dao.UserDAOImple;
import com.jfsfeb.airlinereservationsystemcollection.service.AdminService;
import com.jfsfeb.airlinereservationsystemcollection.service.AdminServiceImple;
import com.jfsfeb.airlinereservationsystemcollection.service.UserService;
import com.jfsfeb.airlinereservationsystemcollection.service.UserServiceImple;

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
