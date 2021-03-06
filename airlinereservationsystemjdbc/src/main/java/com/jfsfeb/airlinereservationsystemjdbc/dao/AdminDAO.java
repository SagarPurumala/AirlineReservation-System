package com.jfsfeb.airlinereservationsystemjdbc.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;



public interface AdminDAO {
	
	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();
	
	List<BookingDetails> getBookingStatus();
}
