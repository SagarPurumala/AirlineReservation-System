package com.jfsfeb.airlinereservationsystemspring.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="bookingstatus")
public class BookingDetails implements Serializable{
	@Id
	@Column(name="ticket_id")
	private int ticketId;
	@Column(name="id")
	private int id;
	@Column(name="flight_id")
	private int flightId;
	@Column(name="noofseatsbooked")
	private int noofseatsbooked;
	
}
