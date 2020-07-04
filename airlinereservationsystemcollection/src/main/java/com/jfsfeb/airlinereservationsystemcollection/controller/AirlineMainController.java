
package com.jfsfeb.airlinereservationsystemcollection.controller;

import com.jfsfeb.airlinereservationsystemcollection.repository.AirlineRepository;

public class AirlineMainController {
	public static void main(String[] args) {
		/*
		 * To store some data calling Respository
		 */
		AirlineRepository.addToDataBase();
		SubAirlineMain.airlineOperations();
	}
}
