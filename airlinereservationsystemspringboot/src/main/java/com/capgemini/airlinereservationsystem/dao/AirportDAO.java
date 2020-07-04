package com.capgemini.airlinereservationsystem.dao;


import com.capgemini.airlinereservationsystem.beans.AirportBeans;

public interface AirportDAO {

	public boolean addAirport(AirportBeans airport);

	public boolean updateAirport(AirportBeans airport);

	public boolean deleteAirport(String abbreviation);

}
