package com.capgemini.airlinereservationsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.airlinereservationsystem.beans.AirlineExecutiveBeans;
import com.capgemini.airlinereservationsystem.dao.AirlineExecutiveDAO;

@Service
public class AirlineExecutiveServiceImpl implements AirlineExecutiveService {

	@Autowired
	private AirlineExecutiveDAO airlineDao;

	@Override
	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber) {

		return airlineDao.viewFlightOccupancy(flightNumber);
	}

}
