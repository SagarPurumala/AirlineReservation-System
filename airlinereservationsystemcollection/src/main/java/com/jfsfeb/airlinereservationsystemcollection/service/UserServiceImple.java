package com.jfsfeb.airlinereservationsystemcollection.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemcollection.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemcollection.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemcollection.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemcollection.dto.UserInfo;
import com.jfsfeb.airlinereservationsystemcollection.exception.ARSException;
import com.jfsfeb.airlinereservationsystemcollection.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemcollection.validation.Validation;

public class UserServiceImple implements UserService {

	private UserDAO dao = AirlineFactory.getUserDAOImplInstance();
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
		
		if(validation.validatedId(user.getUserId())) {
			if(validation.validatedName(user.getUserName())) {
				if(validation.validatedMobile(user.getMobileNumber())) {
					if(validation.validatedEmail(user.getEmailId())) {
						if(validation.validatedPassword(user.getPassword())) {
							return dao.registerUser(user);
						}
					}
					
				}
			}
		}
		throw new ARSException("invalid inputs");
		
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
