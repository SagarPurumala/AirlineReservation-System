package com.jfsfeb.airlinereservationsystemjdbc.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;


public interface UserDAO {
	boolean registerUser(User user);

	User authenticateUser(String emailId, String password);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();
	
	BookingStatus bookRequest(BookingStatus bookingStatus);
	
	List<FlightDetails> searchFlightBySourceAndDestination(String source,String destination);
}
