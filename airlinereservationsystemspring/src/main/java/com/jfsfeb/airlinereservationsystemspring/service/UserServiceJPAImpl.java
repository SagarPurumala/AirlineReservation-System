package com.jfsfeb.airlinereservationsystemspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.airlinereservationsystemspring.bean.BookingDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;
import com.jfsfeb.airlinereservationsystemspring.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemspring.validation.Validation;

@Service
public class UserServiceJPAImpl implements UserService {
    @Autowired
	private UserDAO dao;
    @Autowired
	private Validation validation;

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
		if (bookingStatus != null) {
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
	
	@Override
	public boolean cancelTicket(int ticketId) {
		if (validation.validatedId(ticketId)) {
			return dao.cancelTicket(ticketId);
		}
		return false;
	}

	@Override
	public List<BookingDetails> getTicketDetails(int userId) {
		if(validation.validatedId(userId)) {
			return dao.getTicketDetails(userId);
			}
			return null;
	}


}
