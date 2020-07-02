package com.jfsfeb.airlinereservationsystemjdbc.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;

public interface AirlineService {
	public boolean register(User admin);
	public User authenticate(String email, String password);
	public List<FlightDetails> getFlightDetails();
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination);

}
