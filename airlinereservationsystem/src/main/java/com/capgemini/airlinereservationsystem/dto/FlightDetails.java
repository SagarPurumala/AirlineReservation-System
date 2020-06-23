package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

import java.time.LocalDateTime;

import lombok.Data;
@Data
@SuppressWarnings("serial")
public class FlightDetails implements Serializable {
	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	private int noofseatsavailable;
	private LocalDateTime arrivalDateTime;
	private LocalDateTime departureDateTime;
	public FlightDetails() {
 	
	}
	public FlightDetails(int flightId, String flightName, String source, String destination, int noofseatsavailable,
			LocalDateTime arrivalDateTime, LocalDateTime departureDateTime) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.noofseatsavailable = noofseatsavailable;
		this.arrivalDateTime = arrivalDateTime;
		this.departureDateTime = departureDateTime;
	}

}
