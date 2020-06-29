package com.jfsfeb.airlinereservationsystemjdbc.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;

public class AdminServiceJDBCImpl implements AdminService{

	@Override
	public boolean registerAdmin(User admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User authenticateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addFlights(FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFlight(int flightId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookingStatus> getBookingStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateFlightID(int flightid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateSource(String source) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateDestination(String destination) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateFlightName(String flightname) {
		// TODO Auto-generated method stub
		return false;
	}

}
