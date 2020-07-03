package com.jfsfeb.airlinereservationsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.airlinereservationsystemspring.bean.ARSResponseBean;
import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.User;
import com.jfsfeb.airlinereservationsystemspring.service.AirlineService;

@RestController
public class AirlineController {
	@Autowired
	AirlineService airlineService;

	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ARSResponseBean login(@RequestBody User user) {
		User userLogin = airlineService.authenticate(user.getEmailId(), user.getPassword());
		ARSResponseBean responseBean = new ARSResponseBean();
		if (userLogin != null) {
			responseBean.setMessage("User Logged in Successfully");
			responseBean.setUser(userLogin);
		} else {
			responseBean.setError(true);
			responseBean.setMessage("User Details which was given is invalid, Unable to login");

		}
		return responseBean;
	}

	@PostMapping(path = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ARSResponseBean addUser(@RequestBody User user) {
		boolean isAdded = airlineService.register(user);
		ARSResponseBean response = new ARSResponseBean();
		if (isAdded) {
			response.setMessage("User Added Successfully");
		} else {
			response.setError(true);
			response.setMessage("User Can't Be Registered,As Id Already Exist In the Airline");
		}
		return response;
	}

	@GetMapping(path = "/getAllFlightDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ARSResponseBean getAllUsers() {
		List<FlightDetails> flightList = airlineService.getFlightDetails();
		ARSResponseBean response = new ARSResponseBean();
		if (flightList != null && !flightList.isEmpty()) {
			response.setData(flightList);
		} else {
			response.setError(true);
			response.setMessage("No Users Found in the Library");
		}

		return response;
	}

	@GetMapping(path = "/searchFlighBySource", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void searchFlighBySource(@PathVariable(name = "source") String source, String destination) {
		List<FlightDetails> flightList = airlineService.searchFlightBySourceAndDestination(source, destination);

		ARSResponseBean responseBean = new ARSResponseBean();
		if (flightList != null && flightList.isEmpty()) {
			responseBean.setMessage("flight available for " + source + "and" + destination);
			responseBean.setData(flightList);

		} else {
			responseBean.setError(true);
			responseBean.setMessage("No flight available from" + source);
		}
	}
}
