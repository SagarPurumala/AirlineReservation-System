package com.jfsfeb.airlinereservationsystemjdbc.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;

public interface UserService {
	
	boolean registerUser(User user);

	User authenticateUser(String emailId, String password);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	BookingStatus bookRequest(User user,FlightDetails flight);
	
	List<FlightDetails> searchFlightBySourceAndDestination(String source,String destination);

}
