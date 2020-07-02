package com.jfsfeb.airlinereservationsystemspring.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.User;



public interface AirlineDAO {
	public boolean register(User admin);
	public User authenticate(String email, String password);
	public List<FlightDetails> getFlightDetails();
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination);
}
