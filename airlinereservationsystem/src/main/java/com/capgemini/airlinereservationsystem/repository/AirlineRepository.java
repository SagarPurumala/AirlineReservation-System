package com.capgemini.airlinereservationsystem.repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;


import com.capgemini.airlinereservationsystem.dto.AdminInfo;
import com.capgemini.airlinereservationsystem.dto.BookingStatus;
import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;

public class AirlineRepository {

	public static final ArrayList<AdminInfo> ADMIN_INFOS = new ArrayList<AdminInfo>();
	public static final ArrayList<UserInfo> USER_INFOS = new ArrayList<UserInfo>();
	public static final ArrayList<FlightDetails> FLIGHT_DETAILS = new ArrayList<FlightDetails>();
	public static final ArrayList<BookingStatus> STATUS = new ArrayList<BookingStatus>();
	
	public static void addToDataBase() {
		ADMIN_INFOS.add(new AdminInfo(213,"admin","admin1@gmail.com", "Admin1@",987563421));

		USER_INFOS.add(new UserInfo(101,"sagar","sagar1@gmail.com","Sagar1@","9642726909"));
		USER_INFOS.add(new UserInfo(102,"aravind","aravind1@gmail.com","Aravind1@","9783425122"));
		USER_INFOS.add(new UserInfo(103, "srikanth", "srikanth1@gmail.com", "Srikanth1@","9234876231"));

		FLIGHT_DETAILS.add(new FlightDetails(201, "SpiceJet", "Hyderabad", "Bangalore", 13,LocalDateTime.of(2020, Month.AUGUST, 3, 10, 10),LocalDateTime.of(2020, Month.AUGUST, 3, 11, 10)));
		FLIGHT_DETAILS.add(new FlightDetails(202, "IndiGo", "Delhi", "Mumbai", 10,LocalDateTime.of(2020, Month.JULY,25, 9, 00),LocalDateTime.of(2020, Month.JULY,25, 9, 55)));
		FLIGHT_DETAILS.add(new FlightDetails(203, "GoAir", "Chennai", "Hyderabad", 12,LocalDateTime.of(2020, Month.AUGUST, 13, 10, 10),LocalDateTime.of(2020, Month.AUGUST, 13, 11, 10)));
		FLIGHT_DETAILS.add(new FlightDetails(204, "AirAsia", "Mumbai", "Hyderabad", 8,LocalDateTime.of(2020, Month.SEPTEMBER,15, 10, 10),LocalDateTime.of(2020, Month.SEPTEMBER,15, 12, 10)));
		FLIGHT_DETAILS.add(new FlightDetails(205, "TruJet", "Hyderabad", "Delhi", 10,LocalDateTime.of(2020, Month.OCTOBER, 12, 10, 10),LocalDateTime.of(2020, Month.OCTOBER, 12, 12, 10)));

	}
}
