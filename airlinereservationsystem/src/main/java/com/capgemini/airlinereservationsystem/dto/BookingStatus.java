package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

import lombok.Data;
@Data
@SuppressWarnings("serial")
public class BookingStatus implements Serializable {
	private FlightDetails flightDetails;
	private UserInfo userInfo;
	private int noofSeatsBooked;



}
