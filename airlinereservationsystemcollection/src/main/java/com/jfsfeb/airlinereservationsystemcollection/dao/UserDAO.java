package com.jfsfeb.airlinereservationsystemcollection.dao;


import java.util.List;

import com.jfsfeb.airlinereservationsystemcollection.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemcollection.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemcollection.dto.UserInfo;

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
