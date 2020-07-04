package com.capgemini.airlinereservationsystem.dao;

import com.capgemini.airlinereservationsystem.beans.AirlineExecutiveBeans;

public interface AirlineExecutiveDAO {

	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber);

}
