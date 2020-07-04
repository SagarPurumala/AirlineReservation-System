package com.jfsfeb.airlinereservationsystemcollection.service;


import java.util.List;

import com.jfsfeb.airlinereservationsystemcollection.dto.AdminInfo;
import com.jfsfeb.airlinereservationsystemcollection.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemcollection.dto.FlightDetails;


public interface AdminService {
	
	boolean registerAdmin(AdminInfo admin);

	AdminInfo authenticateAdmin(String email, String password);

	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	List<BookingStatus> getBookingStatus();
	
	boolean validateFlightID(int flightid);
	
	boolean validateSource(String source);
	
	boolean validateDestination(String destination);
	
	boolean validateFlightName(String flightname);
	
}
