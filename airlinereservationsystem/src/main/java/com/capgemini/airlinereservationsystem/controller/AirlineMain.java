
package com.capgemini.airlinereservationsystem.controller;

import com.capgemini.airlinereservationsystem.repository.AirlineRepository;

public class AirlineMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AirlineRepository.addToDataBase();
		SubAirlineMain.airlineOperations();
	}

}
