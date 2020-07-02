package com.jfsfeb.airlinereservationsystemhibernate.factory;

import com.jfsfeb.airlinereservationsystemhibernate.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemhibernate.dao.AdminDAOJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.dao.AirlineDAO;
import com.jfsfeb.airlinereservationsystemhibernate.dao.AirlineDAOJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemhibernate.dao.UserDAOJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.service.AdminSeriveJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.service.AdminService;
import com.jfsfeb.airlinereservationsystemhibernate.service.AirlineService;
import com.jfsfeb.airlinereservationsystemhibernate.service.AirlineServiceJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.service.UserService;
import com.jfsfeb.airlinereservationsystemhibernate.service.UserServiceJPAImpl;


public class AirlineFactory {
	private AirlineFactory() {
		
	}
	public static AirlineDAO getAirlineDAOImplInstance() {
		AirlineDAO airlineDAO=new AirlineDAOJPAImpl();
		return airlineDAO;
	}
	 public static AirlineService getAirlineServiceImplInstance() {
	    	AirlineService airlineService=new AirlineServiceJPAImpl();
	    	return airlineService;
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
