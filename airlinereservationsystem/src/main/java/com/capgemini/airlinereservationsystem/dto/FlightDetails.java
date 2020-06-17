package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

import java.time.LocalDateTime;

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
		super();
	}
//	public FlightDetails(int flightId, String flightName, String source, String destination, int noofseatsavailable) {
//		super();
//		this.flightId = flightId;
//		this.flightName = flightName;
//		this.source = source;
//		this.destination = destination;
//		this.noofseatsavailable = noofseatsavailable;
//	}
	
	public int getFlightId() {
		return flightId;
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

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNoofseatsavailable() {
		return noofseatsavailable;
	}
	public void setNoofseatsavailable(int noofseatsavailable) {
		this.noofseatsavailable = noofseatsavailable;
	}
	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", flightName=" + flightName + ", source=" + source
				+ ", destination=" + destination + ", noofseatsavailable=" + noofseatsavailable + "]";
	}


}
