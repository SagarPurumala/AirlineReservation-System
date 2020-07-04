package com.jfsfeb.airlinereservationsystemcollection.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemcollection.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemcollection.dto.AdminInfo;
import com.jfsfeb.airlinereservationsystemcollection.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemcollection.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemcollection.exception.ARSException;
import com.jfsfeb.airlinereservationsystemcollection.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemcollection.validation.Validation;

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
		if(validation.validatedId(admin.getId())) {
			if(validation.validatedName(admin.getName())) {
				if(validation.validatedMobile(admin.getMobileNo())) {
					if(validation.validatedEmail(admin.getEmailId())) {
						if(validation.validatedPassword(admin.getPassword())) {
							return dao.registerAdmin(admin);
						}
					}
					
				}
			}
		}
		throw new ARSException("invalid inputs");
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
