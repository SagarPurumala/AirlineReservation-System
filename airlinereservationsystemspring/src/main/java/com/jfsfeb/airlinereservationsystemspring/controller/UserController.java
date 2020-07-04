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
import com.jfsfeb.airlinereservationsystemspring.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/bookingRequest",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public  ARSResponseBean bookingRequest(@RequestBody BookingDetails bookingDetails) {
		BookingDetails isAdded=userService.bookRequest(bookingDetails);
	
	    ARSResponseBean responseBean=new ARSResponseBean();
		if(isAdded!=null) {
			responseBean.setMessage("Request placed to Airline Management");
			responseBean.setBookingDetails(isAdded);
			
		}else {
			responseBean.setError(true);
			responseBean.setMessage("Invalid Request of booking");
		}
	    
	    return responseBean;
	}
	
	@DeleteMapping(path = "/cancelticket/{ticketId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ARSResponseBean cancelTicket(@PathVariable Integer ticketId) {
		boolean isDeleted = userService.cancelTicket(ticketId);
		ARSResponseBean response = new ARSResponseBean();
		if (isDeleted) {
			response.setMessage("Ticket cancelled Successfully");
		} else {
			response.setError(true);
			response.setMessage("Unable To cancel the Ticket, As it is Not Present in the Airline reservation system");
		}
		return response;
	}
	@GetMapping(path = "/searchTicket", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void searchTicketId(@PathVariable(name = "id") Integer id) {
		List<BookingDetails> bookingList = userService.getTicketDetails(id);

		ARSResponseBean responseBean = new ARSResponseBean();
		if (bookingList != null && bookingList.isEmpty()) {
			responseBean.setMessage("Ticket Details based on userId "+id);
			responseBean.setData(bookingList);

		} else {
			responseBean.setError(true);
			responseBean.setMessage("No Ticket Details found on userId "+id);
		}
	}
}
