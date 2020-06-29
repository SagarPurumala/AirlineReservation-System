package com.jfsfeb.airlinereservationsystemjdbc.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
@SuppressWarnings("serial")
@Data
public class FlightDetails implements Serializable{
	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	private int noofseatsavailable;
	private LocalDateTime arrivalDateTime;
	private LocalDateTime departureDateTime;

}
