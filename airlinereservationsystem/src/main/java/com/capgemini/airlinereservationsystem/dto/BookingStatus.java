package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookingStatus implements Serializable {
	private FlightDetails flightDetails;
	private UserInfo userInfo;
	private int noofSeatsBooked;

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getNoofSeatsBooked() {
		return noofSeatsBooked;
	}

	public void setNoofSeatsBooked(int noofSeatsBooked) {
		this.noofSeatsBooked = noofSeatsBooked;
	}

}
