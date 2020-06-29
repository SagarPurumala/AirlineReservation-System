package com.jfsfeb.airlinereservationsystemjdbc.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;

public class UserDAOJDBCImple implements UserDAO{

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User authenticateUser(String emailId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingStatus bookRequest(User user, FlightDetails Flight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
