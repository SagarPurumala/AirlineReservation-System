package com.jfsfeb.airlinereservationsystem.service;


import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.AdminInfo;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;

public interface AdminService {
	
	boolean registerAdmin(AdminInfo admin);

	AdminInfo authenticateAdmin(String email, String password);

	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	boolean bookingStatus(UserInfo user, FlightDetails flightDetails);
}
