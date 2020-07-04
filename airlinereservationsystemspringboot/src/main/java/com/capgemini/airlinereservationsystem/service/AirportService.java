package com.capgemini.airlinereservationsystem.service;

import java.util.List;

import com.capgemini.airlinereservationsystem.beans.AirportBeans;

public interface AirportService {
	
	public boolean addAirport(AirportBeans airport);

	public boolean updateAirport(AirportBeans airport);

	public boolean deleteAirport(String abbreviation);

	public List<AirportBeans> getAllAirport();
	

	
}
