package com.jfsfeb.airlinereservationsystemjdbc.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;

public interface UserDAO {

	List<FlightDetails> searchFlightByName(String flightname);

	List<FlightDetails> searchFlightBySource(String source);

	List<FlightDetails> searchFlightByDestination(String destination);

	List<FlightDetails> getFlightDetails();

	BookingStatus bookRequest(BookingStatus bookingStatus);

	List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination);
}
