package com.jfsfeb.airlinereservationsystem.repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.AdminInfo;
import com.jfsfeb.airlinereservationsystem.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;

public class AirlineRepository {

	public static final List<AdminInfo> ADMIN_INFOS = new ArrayList<AdminInfo>();
	public static final List<UserInfo> USER_INFOS = new ArrayList<UserInfo>();
	public static final List<FlightDetails> FLIGHT_DETAILS = new ArrayList<FlightDetails>();
	public static final List<BookingStatus> STATUS = new ArrayList<BookingStatus>();

	public static void addToDataBase() {

		AdminInfo admin = new AdminInfo();
		admin.setId(2134);
		admin.setName("admin");
		admin.setEmailId("admin1@gmail.com");
		admin.setPassword("Admin1@");
		admin.setMobileNo(987654321l);
		ADMIN_INFOS.add(admin);

		UserInfo user = new UserInfo();
		user.setUserId(1001);
		user.setUserName("sagar");
		user.setEmailId("sagar1@gmail.com");
		user.setPassword("Sagar1@");
		user.setMobileNumber("9642726909");
		USER_INFOS.add(user);

		FlightDetails flight = new FlightDetails();
		flight.setFlightId(2001);
		flight.setFlightName("SpiceJet");
		flight.setSource("Hyderabad");
		flight.setDestination("Bangalore");
		flight.setNoofseatsavailable(20);
		flight.setArrivalDateTime(LocalDateTime.of(2020, Month.AUGUST, 3, 10, 10));
		flight.setDepartureDateTime(LocalDateTime.of(2020, Month.AUGUST, 3, 11, 10));
		FLIGHT_DETAILS.add(flight);

		FlightDetails flight1 = new FlightDetails();
		flight1.setFlightId(2002);
		flight1.setFlightName("IndiGo");
		flight1.setSource("Delhi");
		flight1.setDestination("Mumbai");
		flight1.setNoofseatsavailable(15);
		flight1.setArrivalDateTime(LocalDateTime.of(2020, Month.JULY, 25, 9, 00));
		flight1.setDepartureDateTime(LocalDateTime.of(2020, Month.JULY, 25, 9, 55));
		FLIGHT_DETAILS.add(flight1);

		FlightDetails flight2 = new FlightDetails();
		flight2.setFlightId(2003);
		flight2.setFlightName("GoAir");
		flight2.setSource("Chennai");
		flight2.setDestination("Hyderabad");
		flight2.setNoofseatsavailable(12);
		flight2.setArrivalDateTime(LocalDateTime.of(2020, Month.AUGUST, 13, 10, 10));
		flight2.setDepartureDateTime(LocalDateTime.of(2020, Month.AUGUST, 13, 11, 10));
		FLIGHT_DETAILS.add(flight2);

		FlightDetails flight3 = new FlightDetails();
		flight3.setFlightId(2004);
		flight3.setFlightName("AirAsia");
		flight3.setSource("Mumbai");
		flight3.setDestination("Hyderabad");
		flight3.setNoofseatsavailable(8);
		flight3.setArrivalDateTime(LocalDateTime.of(2020, Month.SEPTEMBER, 15, 10, 10));
		flight3.setDepartureDateTime(LocalDateTime.of(2020, Month.SEPTEMBER, 15, 12, 10));
		FLIGHT_DETAILS.add(flight3);
		
		BookingStatus status=new BookingStatus();
		status.setFlightDetails(flight1);
		status.setUserInfo(user);
		status.setNoofSeatsBooked(2);
		STATUS.add(status);

	}
}
