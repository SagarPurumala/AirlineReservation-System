package com.jfsfeb.airlinereservationsystemhibernate.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemhibernate.dto.FlightDetails;


public interface UserDAO {

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	BookingStatus bookRequest(BookingStatus bookingStatus);

	List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination);

	boolean cancelTicket(int ticketId);

	List<BookingStatus> getTicketDetails(int userId);
	
	
}
