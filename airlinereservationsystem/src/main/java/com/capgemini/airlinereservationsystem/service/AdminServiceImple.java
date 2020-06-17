package com.capgemini.airlinereservationsystem.service;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dao.AdminDAO;
import com.capgemini.airlinereservationsystem.dao.AdminDAOImple;
import com.capgemini.airlinereservationsystem.dto.AdminInfo;
import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;

public class AdminServiceImple implements AdminService{

	private AdminDAO dao=new AdminDAOImple();
	@Override
	public boolean registerAdmin(AdminInfo admin) {
		// TODO Auto-generated method stub
		return dao.registerAdmin(admin);
	}

	@Override
	public AdminInfo authenticateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authenticateAdmin(email, password);
	}

	@Override
	public boolean addFlights(FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return dao.addFlights(flightDetails);
	}

	@Override
	public boolean removeFlight(int flightId) {
		// TODO Auto-generated method stub
		return dao.removeFlight(flightId);
	}

	@Override
	public ArrayList<FlightDetails> searchFlightByName(String flightname) {
		// TODO Auto-generated method stub
		return dao.searchFlightByName(flightname);
	}

	@Override
	public ArrayList<FlightDetails> searchFlightBySource(String source) {
		// TODO Auto-generated method stub
		return dao.searchFlightBySource(source);
	}

	@Override
	public ArrayList<FlightDetails> searchFlightByDestination(String destination) {
		// TODO Auto-generated method stub
		return dao.searchFlightByDestination(destination);
	}

	@Override
	public ArrayList<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return dao.getFlightDetails();
	}

	@Override
	public boolean bookingStatus(UserInfo user, FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return false;
	}

}
