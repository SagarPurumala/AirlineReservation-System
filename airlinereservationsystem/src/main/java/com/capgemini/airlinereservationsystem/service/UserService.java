package com.capgemini.airlinereservationsystem.service;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dto.BookingStatus;
import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;

public interface UserService {

	boolean registerUser(UserInfo user);

	UserInfo authenticateUser(String emailId, String password);

	ArrayList<FlightDetails> searchFlightByName(String flightname);

	ArrayList<FlightDetails> searchFlightBySource(String source);

	ArrayList<FlightDetails> searchFlightByDestination(String destination);

	ArrayList<FlightDetails> getFlightDetails();

	BookingStatus bookRequest(UserInfo user,FlightDetails fSource, FlightDetails fDestination);

}
