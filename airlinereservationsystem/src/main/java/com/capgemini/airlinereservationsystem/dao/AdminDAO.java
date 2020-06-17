package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dto.AdminInfo;
import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;

public interface AdminDAO {

	boolean registerAdmin(AdminInfo admin);

	AdminInfo authenticateAdmin(String email, String password);

	boolean addFlights(FlightDetails flightDetails);

	boolean removeFlight(int flightId);

	ArrayList<FlightDetails> searchFlightByName(String flightname);

	ArrayList<FlightDetails> searchFlightBySource(String source);

	ArrayList<FlightDetails> searchFlightByDestination(String destination);

	ArrayList<FlightDetails> getFlightDetails();

	boolean bookingStatus(UserInfo user, FlightDetails flightDetails);

}
