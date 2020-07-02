package com.jfsfeb.airlinereservationsystemjdbc.dto;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class BookingDetails implements Serializable{
	private int ticketId;
	private int id;
	private int flightId;
	private int noofseatsbooked;
	private FlightDetails flightDetails;
	private User user;
	

}
