package com.jfsfeb.airlinereservationsystemjdbc.dto;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BookingStatus implements Serializable{
	private int id;
	private int flightId;
	private int noofseatsbooked;
	private FlightDetails flightDetails;
	private User user;
	

}