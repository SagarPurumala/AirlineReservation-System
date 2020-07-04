package com.capgemini.airlinereservationsystem.config;

import org.springframework.context.annotation.Configuration;

import com.capgemini.airlinereservationsystem.dao.FlightDAO;
import com.capgemini.airlinereservationsystem.dao.FlightDAOJpaImpl;
import com.capgemini.airlinereservationsystem.dao.UserDAO;
import com.capgemini.airlinereservationsystem.dao.UserDAOImpl;

@Configuration
public class AirlineConfigTest {
	
	//@Bean("FlightDAO")
	public FlightDAO getFlightDAO() {
		
		return new FlightDAOJpaImpl();
		
	}
	
	public UserDAO registerUser() {
		return new UserDAOImpl();
	}

}
