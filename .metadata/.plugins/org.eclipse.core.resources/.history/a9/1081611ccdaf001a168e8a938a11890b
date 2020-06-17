package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;

public interface UserDAO {
	boolean registerUser(UserInfo user);

	UserInfo authenticateUser(String emailId, String password);

	ArrayList<FlightDetails> searchFlightByName(String flightname);

	ArrayList<FlightDetails> searchFlightBySource(String source);

	ArrayList<FlightDetails> searchFlightByDestination(String destination);

	ArrayList<FlightDetails> getFlightDetails();

}
