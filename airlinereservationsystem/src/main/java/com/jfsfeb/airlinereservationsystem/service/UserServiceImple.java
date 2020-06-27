package com.jfsfeb.airlinereservationsystem.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystem.dao.UserDAO;
import com.jfsfeb.airlinereservationsystem.dao.UserDAOImple;
import com.jfsfeb.airlinereservationsystem.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;
import com.jfsfeb.airlinereservationsystem.exception.ARSException;
import com.jfsfeb.airlinereservationsystem.validation.Validation;

public class UserServiceImple implements UserService {

	private UserDAO dao = new UserDAOImple();
	private Validation validation = new Validation();

	@Override
	public UserInfo authenticateUser(String emailId, String password) {
		if (validation.validatedEmail(emailId)) {
			if (validation.validatedPassword(password)) {
				return dao.authenticateUser(emailId, password);
			}
		}
		return null;
	}

	@Override
	public boolean registerUser(UserInfo user) {
		if (user != null) {
			return dao.registerUser(user);
		}
		return false;
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		if (validation.validatedName(flightname)) {
			return dao.searchFlightByName(flightname);
		}
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		if (validation.validatedSource(source)) {
			return dao.searchFlightBySource(source);
		}
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		if (validation.validatedDestination(destination)) {
			return dao.searchFlightByDestination(destination);
		}
		return null;
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		return dao.getFlightDetails();
	}

	@Override
	public BookingStatus bookRequest(UserInfo user, FlightDetails flight) {
		if (user != null && flight != null) {
			return dao.bookRequest(user, flight);
		}
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		if (validation.validatedSource(source)) {
			if (validation.validatedDestination(destination)) {
				return dao.searchFlightBySourceAndDestination(source, destination);
			}
		}
		return null;
	}

}
