package com.jfsfeb.airlinereservationsystemhibernate.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemhibernate.dto.User;


public interface AirlineDAO {
	public boolean register(User admin);
	public User authenticate(String email, String password);
	public List<FlightDetails> getFlightDetails();
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination);
}
