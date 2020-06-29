package com.jfsfeb.airlinereservationsystem.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystem.dao.AdminDAO;

import com.jfsfeb.airlinereservationsystem.dto.AdminInfo;
import com.jfsfeb.airlinereservationsystem.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;

import com.jfsfeb.airlinereservationsystem.exception.ARSException;
import com.jfsfeb.airlinereservationsystem.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystem.validation.Validation;

public class AdminServiceImple implements AdminService {

	Validation validation = new Validation();
	AdminDAO dao = AirlineFactory.getAdminDAOImplInstance();

	@Override
	public AdminInfo authenticateAdmin(String email, String password) {

		if (validation.validatedEmail(email)) {
			if (validation.validatedPassword(password)) {
				return dao.authenticateAdmin(email, password);
			} 
		} 
		return null;

	}

	@Override
	public boolean registerAdmin(AdminInfo admin) {
		if (admin != null) {
			return dao.registerAdmin(admin);
		}
		throw new ARSException("Enter correct details");
	}

	@Override
	public boolean addFlights(FlightDetails flightDetails) {
		if (flightDetails != null) {
			return dao.addFlights(flightDetails);
		}
		throw new ARSException("Enter Correct details");

	}

	@Override
	public boolean removeFlight(int flightId) {
		if (validation.validatedId(flightId)) {
			return dao.removeFlight(flightId);
		}
		return false;
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		if (validation.validatedName(flightname)) {
			return dao.searchFlightByName(flightname);
		}
		throw new ARSException("Enter Correct Details");
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		if (validation.validatedSource(source)) {
			return dao.searchFlightBySource(source);
		}
		return null;
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		if (validation.validatedDestination(destination)) {

			return dao.searchFlightByDestination(destination);
		}
		return null;
	}

	@Override
	public List<FlightDetails> getFlightDetails() {

		return dao.getFlightDetails();
	}

	@Override
	public List<BookingStatus> getBookingStatus() {
		// TODO Auto-generated method stub
		return dao.getBookingStatus();
	}

	@Override
	public boolean validateFlightID(int flightid) {
		if(validation.validatedId(flightid)){
		  return true;
		}
		throw new ARSException("Invalid Id! Id should contain exactly 4 positive digits");
	}

}
