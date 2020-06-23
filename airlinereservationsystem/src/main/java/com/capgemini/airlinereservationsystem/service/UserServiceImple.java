package com.capgemini.airlinereservationsystem.service;


import java.util.List;

import com.capgemini.airlinereservationsystem.dao.UserDAO;
import com.capgemini.airlinereservationsystem.dao.UserDAOImple;
import com.capgemini.airlinereservationsystem.dto.BookingStatus;
import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;

public class UserServiceImple implements UserService {

	private UserDAO dao=new UserDAOImple();
	@Override
	public boolean registerUser(UserInfo user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}

	@Override
	public UserInfo authenticateUser(String emailId, String password) {
		// TODO Auto-generated method stub
		return dao.authenticateUser(emailId, password);
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		// TODO Auto-generated method stub
		return dao.searchFlightByName(flightname);
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		// TODO Auto-generated method stub
		return dao.searchFlightBySource(source);
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		// TODO Auto-generated method stub
		return dao.searchFlightByDestination(destination);
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return dao.getFlightDetails();
	}

	@Override
	public BookingStatus bookRequest(UserInfo user,FlightDetails flight) {
		// TODO Auto-generated method stub
		return dao.bookRequest(user,flight);
	}

}
