package com.jfsfeb.airlinereservationsystemhibernate.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemhibernate.dto.User;
import com.jfsfeb.airlinereservationsystemhibernate.exception.ARSException;
import com.jfsfeb.airlinereservationsystemhibernate.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemhibernate.validation.Validation;


public class UserServiceJPAImpl implements UserService{

	private UserDAO dao = AirlineFactory.getUserDAOImplInstance();
	private Validation validation = new Validation();
	@Override
	public boolean registerUser(User user) {
		if(validation.validatedId(user.getId())) {
			if(validation.validatedName(user.getName())) {
				if(validation.validatedMobile(user.getMobileNumber())) {
					if(validation.validatedEmail(user.getEmailId())) {
						if(validation.validatedPassword(user.getPassword())) {
							if(validation.validatedUserRole(user.getRole())) {
								
								return dao.registerUser(user);
							}
						}
					}
					
				}
			}
		}
		throw new ARSException("invalid inputs");
	}

	@Override
	public User authenticateUser(String emailId, String password) {
		if (validation.validatedEmail(emailId)) {
			if (validation.validatedPassword(password)) {
				return dao.authenticateUser(emailId, password);
			}
		}
		return null;
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
	public BookingStatus bookRequest(BookingStatus bookingStatus) {
		if (bookingStatus!=null) {
			return dao.bookRequest(bookingStatus);
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
