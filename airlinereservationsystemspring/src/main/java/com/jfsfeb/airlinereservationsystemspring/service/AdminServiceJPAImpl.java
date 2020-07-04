package com.jfsfeb.airlinereservationsystemspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.airlinereservationsystemspring.bean.BookingDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;
import com.jfsfeb.airlinereservationsystemspring.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemspring.exception.ARSException;
import com.jfsfeb.airlinereservationsystemspring.validation.Validation;




@Service
public class AdminServiceJPAImpl implements AdminService{
	@Autowired
	Validation validation;
	@Autowired
	AdminDAO dao ;
	

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
	public List<BookingDetails> getBookingStatus() {
		return dao.getBookingStatus();
	}

	@Override
	public boolean validateFlightID(int flightid) {
		if(validation.validatedId(flightid)){
			  return true;
			}
			throw new ARSException("Invalid Id! Id should contain exactly 4 positive digits");
	}

	@Override
	public boolean validateSource(String source) {
		if(validation.validatedSource(source)) {
	    	  return true;
	      }
	      
	      throw new ARSException("Invalid Source! Source should have atleast 4 characters");
	}

	@Override
	public boolean validateDestination(String destination) {
		if(validation.validatedDestination(destination)) {
			return true;
		}
		throw new ARSException("Invalid Destination! Destination should have atleast 4 characters");
	}

	@Override
	public boolean validateFlightName(String flightname) {
		 if(validation.validatedName(flightname)) {
		    	return true;
		    }
		    throw new ARSException("Invalid Name! Name should have atleast 4 characters");
	}
}
