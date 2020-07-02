package com.jfsfeb.airlinereservationsystemjdbc.service;

import java.util.List;


import com.jfsfeb.airlinereservationsystemjdbc.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemjdbc.validation.Validation;

public class UserServiceJDBCImpl implements UserService{

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
	public BookingDetails bookRequest(BookingDetails bookingStatus) {
	
			return dao.bookRequest(bookingStatus);
		
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

	@Override
	public boolean cancelTicket(int ticketId) {
		if (validation.validatedId(ticketId)) {
			return dao.cancelTicket(ticketId);
		}
		return false;
	}

}
