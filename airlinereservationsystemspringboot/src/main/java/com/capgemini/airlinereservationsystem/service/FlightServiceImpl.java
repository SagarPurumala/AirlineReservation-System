package com.capgemini.airlinereservationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.airlinereservationsystem.beans.FlightBooking;
import com.capgemini.airlinereservationsystem.beans.FlightInformation;
import com.capgemini.airlinereservationsystem.dao.BookingDAO;
import com.capgemini.airlinereservationsystem.dao.FlightDAO;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDAO flightdao;

	@Autowired
	private BookingDAO bookingDao;

	@Override
	public FlightInformation getFlight(String flightNumber) {
		return flightdao.getFlight(flightNumber);
	}

	@Override
	public boolean addFlight(FlightInformation flightInformation) {
		return flightdao.addFlight(flightInformation);
	}

	@Override
	public boolean updateFlight(FlightInformation flightInformation) {
		return flightdao.updateFlight(flightInformation);
	}

	@Override
	public boolean deleteFlight(String flightNumber) {
		return flightdao.deleteFlight(flightNumber);
	}

	@Override
	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate) {

		return flightdao.search(departureCity, arrivalCity, departureDate);
	}

	@Override
	public List<FlightInformation> getAllFlights() {
		return flightdao.getAllFlights();
	}

	@Override
	public FlightBooking bookFlight(FlightBooking flightBooking) {
		return bookingDao.bookFlight(flightBooking);
	}

	@Override
	public List<FlightBooking> getAllBooking(String userId) {
		return bookingDao.getAllBooking(userId);
	}

	@Override
	public boolean deleteBooking(String bookingId) {
		return bookingDao.deleteBooking(bookingId);
	}

}
