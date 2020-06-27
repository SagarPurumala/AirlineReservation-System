package com.jfsfeb.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.AdminInfo;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;
import com.jfsfeb.airlinereservationsystem.exception.ARSException;
import com.jfsfeb.airlinereservationsystem.repository.AirlineRepository;

public class AdminDAOImple implements AdminDAO{

	@Override
	public boolean registerAdmin(AdminInfo admin) {
		// TODO Auto-generated method stub
		for (AdminInfo a1 : AirlineRepository.ADMIN_INFOS) {
			if ((a1.getEmailId()).equals(admin.getEmailId())) {
				return false;
			}
		}
		AirlineRepository.ADMIN_INFOS.add(admin);
		return true;
	}

	@Override
	public AdminInfo authenticateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		for (AdminInfo a2 : AirlineRepository.ADMIN_INFOS) {
			if ((a2.getEmailId().equals(email)) && (a2.getPassword().equals(password))) {
				return a2;
			}
		}
		throw new ARSException("Invalid Credentials");
		
	}

	@Override
	public boolean addFlights(FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		for (FlightDetails b : AirlineRepository.FLIGHT_DETAILS ) {
			if (b.getFlightId() == flightDetails.getFlightId()) {
				return false;
			}
		}
		AirlineRepository.FLIGHT_DETAILS .add(flightDetails);
		return true;
		
	}

	@Override
	public boolean removeFlight(int flightId) {
		// TODO Auto-generated method stub
		boolean removeStatus = false;
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			int retrievedId = retrievedFlight.getFlightId();
			if (flightId == retrievedId) {
				removeStatus = true;
				AirlineRepository.FLIGHT_DETAILS.remove(i);
				break;
			}
		}
		return removeStatus;
		
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightName) {
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
	public List<FlightDetails> searchFlightBySource(String source) {
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
	public List<FlightDetails> searchFlightByDestination(String destination) {
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
	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return AirlineRepository.FLIGHT_DETAILS;
	}
	
	

}
