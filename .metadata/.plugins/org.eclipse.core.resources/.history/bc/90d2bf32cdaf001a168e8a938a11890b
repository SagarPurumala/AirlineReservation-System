package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;


import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;
import com.capgemini.airlinereservationsystem.exception.ARSException;
import com.capgemini.airlinereservationsystem.repository.AirlineRepository;

public class UserDAOImple implements UserDAO{

	@Override
	public boolean registerUser(UserInfo user) {
		// TODO Auto-generated method stub
		for (UserInfo u1 : AirlineRepository.USER_INFOS) {
			if ((u1.getEmailId()).equals(user.getEmailId())) {
				return false;
			}
		}
		AirlineRepository.USER_INFOS.add(user);
		return true;
	}

	@Override
	public UserInfo authenticateUser(String emailId, String password) {
		// TODO Auto-generated method stub
		for (UserInfo u2 : AirlineRepository.USER_INFOS) {
			if ((u2.getEmailId().equals(emailId)) && (u2.getPassword().equals(password))) {
				return u2;
			}
		}
		throw new ARSException("Invalid Credentials");
		
	}

	@Override
	public ArrayList<FlightDetails> searchFlightByName(String flightName) {
		// TODO Auto-generated method stub
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			String retrievedFname = retrievedFlight.getFlightName();
			if (flightName.equals(retrievedFname)) {
				searchList.add(retrievedFlight);
				return searchList;
			}
		}
		if (searchList.size() == 0) {
			throw new ARSException("Flight not found");
		} else {
			return searchList;
		}
	}

	@Override
	public ArrayList<FlightDetails> searchFlightBySource(String source) {
		// TODO Auto-generated method stub
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			String retrievedFSource = retrievedFlight.getSource();
			if (source.equals(retrievedFSource)) {
				searchList.add(retrievedFlight);
			}
		}
		if (searchList.size() == 0) {
			throw new ARSException("Flight not found");
		} else {
			return searchList;
		}
	}

	@Override
	public ArrayList<FlightDetails> searchFlightByDestination(String destination) {
		// TODO Auto-generated method stub
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			String retrievedFDestination = retrievedFlight.getDestination();
			if (destination.equals(retrievedFDestination)) {
				searchList.add(retrievedFlight);
			}
		}
		if (searchList.size() == 0) {
			throw new ARSException("Flight not found");
		} else {
			return searchList;
		}
	}

	@Override
	public ArrayList<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return AirlineRepository.FLIGHT_DETAILS;
	}

}
