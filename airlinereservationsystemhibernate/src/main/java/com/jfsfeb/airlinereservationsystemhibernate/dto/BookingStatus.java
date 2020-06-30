package com.jfsfeb.airlinereservationsystemhibernate.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity
public class BookingStatus implements Serializable{
	@Id
	
	private int id;
	private int flightId;
	private int noofseatsbooked;
	private FlightDetails flightDetails;
	private User user;
}
