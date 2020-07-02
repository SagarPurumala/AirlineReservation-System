package com.jfsfeb.airlinereservationsystemhibernate.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemhibernate.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemhibernate.validation.Validation;


public class UserServiceJPAImpl implements UserService{

	private UserDAO dao = AirlineFactory.getUserDAOImplInstance();
	private Validation validation = new Validation();
	
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
