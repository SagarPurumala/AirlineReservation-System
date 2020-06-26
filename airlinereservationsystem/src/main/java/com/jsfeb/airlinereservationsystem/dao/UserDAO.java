package com.jsfeb.airlinereservationsystem.dao;


import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;

public interface UserDAO {
	boolean registerUser(UserInfo user);

	UserInfo authenticateUser(String emailId, String password);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();
	
	BookingStatus bookRequest(UserInfo user,FlightDetails Flight);
	
	List<FlightDetails> searchFlightBySourceAndDestination(String source,String destination);

}
