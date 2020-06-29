
package com.jfsfeb.airlinereservationsystem.controller;

import com.jfsfeb.airlinereservationsystem.repository.AirlineRepository;

public class AirlineMainController {
	public static void main(String[] args) {
		AirlineRepository.addToDataBase();
		SubAirlineMain.airlineOperations();
	}
}
