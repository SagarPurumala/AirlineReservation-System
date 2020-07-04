package com.jfsfeb.airlinereservationsystemspring.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspring.bean.BookingDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;

public interface UserService {

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	BookingDetails bookRequest(BookingDetails bookingStatus);
	
	List<FlightDetails> searchFlightBySourceAndDestination(String source,String destination);
	
	boolean cancelTicket(int ticketId);

	List<BookingDetails> getTicketDetails(int userId);
}
