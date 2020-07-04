package com.capgemini.airlinereservationsystem.beans;

import javax.persistence.*;
import javax.validation.constraints.Positive;


@Entity
@Table(name = "airport")
public class AirportBeans {
	@Id
	@Column(name = "abbr", unique = true)
	//@Pattern(regexp = "{A-Z}*")
	//@Size(min = 3, max = 5)
	private String abbreviation;

	@Column
	//@Pattern(regexp = "{A-Za-z}*")
	private String airportName;

	@Column
	//@Pattern(regexp = "{A-Za-z}*")
	private String state;

	@Column
	//@Pattern(regexp = "{A-Za-z}*")
	private String city;

	@Column
	@Positive
	//@Size(min = 4, max = 6, message = "Entered zip code is not valid.")
	//@Pattern(regexp = "{0-9}*")
	private int zipCode;

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
