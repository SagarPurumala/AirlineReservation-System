package com.capgemini.airlinereservationsystem.service;


import java.util.List;

import com.capgemini.airlinereservationsystem.dto.BookingStatus;
import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;

public interface UserService {

	boolean registerUser(UserInfo user);

	UserInfo authenticateUser(String emailId, String password);

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	BookingStatus bookRequest(UserInfo user,FlightDetails flight);

}
