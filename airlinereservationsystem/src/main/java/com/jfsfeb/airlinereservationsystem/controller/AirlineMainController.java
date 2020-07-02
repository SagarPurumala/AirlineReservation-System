
package com.jfsfeb.airlinereservationsystem.controller;

import com.jfsfeb.airlinereservationsystem.repository.AirlineRepository;

public class AirlineMainController {
	public static void main(String[] args) {
		/*
		 * To store some data calling Respository
		 */
		AirlineRepository.addToDataBase();
		SubAirlineMain.airlineOperations();
	}
}
