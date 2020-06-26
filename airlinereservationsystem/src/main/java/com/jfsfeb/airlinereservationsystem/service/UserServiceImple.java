package com.jfsfeb.airlinereservationsystem.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;
import com.jfsfeb.airlinereservationsystem.validation.Validation;
import com.jsfeb.airlinereservationsystem.dao.UserDAO;
import com.jsfeb.airlinereservationsystem.dao.UserDAOImple;

public class UserServiceImple implements UserService {

	private UserDAO dao = new UserDAOImple();
	Validation validation = new Validation();

	@Override
	public boolean registerUser(UserInfo user) {

		return dao.registerUser(user);
	}

	@Override
	public UserInfo authenticateUser(String emailId, String password) {
       if(validation.validatedEmail(emailId)) {
			if (validation.validatedPassword(password)) {

				return dao.authenticateUser(emailId, password);
			}
			
       }
       return null;
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {

		return dao.searchFlightByName(flightname);
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {

		return dao.searchFlightBySource(source);
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {

		return dao.searchFlightByDestination(destination);
	}

	@Override
	public List<FlightDetails> getFlightDetails() {

		return dao.getFlightDetails();
	}

	@Override
	public BookingStatus bookRequest(UserInfo user, FlightDetails flight) {
		// TODO Auto-generated method stub
		return dao.bookRequest(user, flight);
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		// TODO Auto-generated method stub
		return dao.searchFlightBySourceAndDestination(source, destination);
	}

}
