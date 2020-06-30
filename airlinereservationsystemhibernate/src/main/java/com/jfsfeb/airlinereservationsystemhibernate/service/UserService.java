package com.jfsfeb.airlinereservationsystemhibernate.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemhibernate.dto.User;



public interface UserService {

	boolean registerUser(User user);

	User authenticateUser(String emailId, String password);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	BookingStatus bookRequest(BookingStatus bookingStatus);
	
	List<FlightDetails> searchFlightBySourceAndDestination(String source,String destination);
}
