package com.jfsfeb.airlinereservationsystem.service;


import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.AdminInfo;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;
import com.jfsfeb.airlinereservationsystem.validation.Validation;
import com.jsfeb.airlinereservationsystem.dao.AdminDAO;
import com.jsfeb.airlinereservationsystem.dao.AdminDAOImple;

public class AdminServiceImple implements AdminService{

	private AdminDAO dao=new AdminDAOImple();
	Validation validation=new Validation();
	@Override
	public boolean registerAdmin(AdminInfo admin) {
	
		return dao.registerAdmin(admin);
	}

	@Override
	public AdminInfo authenticateAdmin(String email, String password) {
		if(validation.validatedEmail(email)) {
			if(validation.validatedPassword(password)) {
				return dao.authenticateAdmin(email, password);
			}
		}
		return null;
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
	public List<FlightDetails> searchFlightByName(String flightname) {
		// TODO Auto-generated method stub
		return dao.searchFlightByName(flightname);
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		// TODO Auto-generated method stub
		return dao.searchFlightBySource(source);
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		// TODO Auto-generated method stub
		return dao.searchFlightByDestination(destination);
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return dao.getFlightDetails();
	}

	@Override
	public boolean bookingStatus(UserInfo user, FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return false;
	}

}
