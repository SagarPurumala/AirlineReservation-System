package com.jfsfeb.airlinereservationsystemspring.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspring.bean.BookingDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;


public interface AdminService {
 
	

	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	List<BookingDetails> getBookingStatus();
	
	boolean validateFlightID(int flightid);
	
	boolean validateSource(String source);
	
	boolean validateDestination(String destination);
	
	boolean validateFlightName(String flightname);
}
