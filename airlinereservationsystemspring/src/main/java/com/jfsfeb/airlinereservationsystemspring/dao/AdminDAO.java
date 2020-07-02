package com.jfsfeb.airlinereservationsystemspring.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspring.bean.BookingStatus;
import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;


public interface AdminDAO {
	
	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();
	
	List<BookingStatus> getBookingStatus();

}
