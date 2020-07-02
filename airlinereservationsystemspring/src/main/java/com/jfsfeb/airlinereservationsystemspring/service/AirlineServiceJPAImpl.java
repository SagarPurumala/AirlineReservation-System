package com.jfsfeb.airlinereservationsystemspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.User;
import com.jfsfeb.airlinereservationsystemspring.dao.AirlineDAO;
import com.jfsfeb.airlinereservationsystemspring.exception.ARSException;
import com.jfsfeb.airlinereservationsystemspring.validation.Validation;


@Service
public class AirlineServiceJPAImpl implements AirlineService{
    @Autowired
	Validation validation;
    @Autowired
	AirlineDAO dao;
	@Override
	public boolean register(User admin) {
		if(validation.validatedId(admin.getId())) {
			if(validation.validatedName(admin.getName())) {
				if(validation.validatedMobile(admin.getMobileNumber())) {
					if(validation.validatedEmail(admin.getEmailId())) {
						if(validation.validatedPassword(admin.getPassword())) {
							if(validation.validatedRole(admin.getRole())) {
							return dao.register(admin);
							}
						}
					}
					
				}
			}
		}
		throw new ARSException("invalid inputs");
	}

	@Override
	public User authenticate(String email, String password) {
		if (validation.validatedEmail(email)) {
			if (validation.validatedPassword(password)) {
				return dao.authenticate(email, password);
			} 
		} 
		return null;
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		return dao.getFlightDetails();
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		if (validation.validatedSource(source)) {
			if (validation.validatedDestination(destination)) {
				return dao.searchFlightBySourceAndDestination(source, destination);
			}
		}
		throw new ARSException("No Flight Details with Source and Destination");
	}


}
