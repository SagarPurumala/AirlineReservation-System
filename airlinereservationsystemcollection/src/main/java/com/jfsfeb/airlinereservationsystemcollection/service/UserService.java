package com.jfsfeb.airlinereservationsystemcollection.service;


import java.util.List;

import com.jfsfeb.airlinereservationsystemcollection.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemcollection.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemcollection.dto.UserInfo;

public interface UserService {

	boolean registerUser(UserInfo user);

	UserInfo authenticateUser(String emailId, String password);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	BookingStatus bookRequest(UserInfo user,FlightDetails flight);
	
	List<FlightDetails> searchFlightBySourceAndDestination(String source,String destination);

}
