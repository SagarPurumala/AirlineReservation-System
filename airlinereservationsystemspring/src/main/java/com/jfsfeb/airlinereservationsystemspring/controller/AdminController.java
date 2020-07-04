package com.jfsfeb.airlinereservationsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.airlinereservationsystemspring.bean.ARSResponseBean;
import com.jfsfeb.airlinereservationsystemspring.bean.BookingDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;
import com.jfsfeb.airlinereservationsystemspring.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@PostMapping(path="/addFlight",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public  ARSResponseBean addFlights(@RequestBody FlightDetails flightDetails) {
		boolean isAdded=adminService.addFlights(flightDetails);
	
	    ARSResponseBean responseBean=new ARSResponseBean();
	    if(isAdded) {
	    	responseBean.setMessage("Flight Added Successfully");
	    }else {
	    	responseBean.setError(true);
	    	responseBean.setMessage("Unable to add the flight");
	    }
	    
	    return responseBean;
	}
	@GetMapping(path="/searchFlighBySource",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public void searchFlighBySource(@PathVariable(name="source")String source) {
		List<FlightDetails>  flightList=adminService.searchFlightBySource(source);
		
		ARSResponseBean responseBean=new ARSResponseBean();
		if(flightList!=null&&flightList.isEmpty()) {
			responseBean.setMessage("flight available from "+source);
			responseBean.setData(flightList);
			
		}else {
			responseBean.setError(true);
			responseBean.setMessage("No flight available from"+source);
		}
	}
	@GetMapping(path="/searchFlighByDestination",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public void searchFlighByDestination(@PathVariable(name="destination")String destination) {
		List<FlightDetails>  flightList=adminService.searchFlightByDestination(destination);
		
		ARSResponseBean responseBean=new ARSResponseBean();
		if(flightList!=null&&flightList.isEmpty()) {
			responseBean.setMessage("flight available from "+destination);
			responseBean.setData(flightList);
			
		}else {
			responseBean.setError(true);
			responseBean.setMessage("No flight available from"+destination);
		}
	}

	@DeleteMapping(path = "/deleteflight/{flightId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ARSResponseBean deleteBook(@PathVariable Integer flightId) {
		boolean isDeleted = adminService.removeFlight(flightId);
		ARSResponseBean response = new ARSResponseBean();
		if (isDeleted) {
			response.setMessage("Flight  Removed Successfully");
		} else {
			response.setError(true);
			response.setMessage("Unable To Remove The Flight, As it is Not Present in the Airline reservation system");
		}
		return response;
	}
	
	@GetMapping(path = "/getAllBookingDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ARSResponseBean getAllUsers() {
		List<BookingDetails> flightList = adminService.getBookingStatus();
		ARSResponseBean response = new ARSResponseBean();
		if (flightList != null && !flightList.isEmpty()) {
			response.setData(flightList);
		} else {
			response.setError(true);
			response.setMessage("No booking Found in the Airline");
		}

		return response;
	}

}//End of Controller
