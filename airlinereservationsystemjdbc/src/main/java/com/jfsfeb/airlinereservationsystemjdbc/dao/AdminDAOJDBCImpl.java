package com.jfsfeb.airlinereservationsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;
import com.jfsfeb.airlinereservationsystemjdbc.execption.ARSException;
import com.jfsfeb.airlinereservationsystemjdbc.utility.JdbcUtility;

public class AdminDAOJDBCImpl implements AdminDAO{
   
	JdbcUtility dbConnector=new JdbcUtility();
	@Override
	public boolean registerAdmin(User admin) {
		try {
			Connection conn = dbConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("addUser"));
			
			pstmt.setInt(1, admin.getId());
			pstmt.setString(2, admin.getName());
			pstmt.setString(3, admin.getEmailId());
			pstmt.setLong(4, admin.getMobileNumber());
			pstmt.setString(5, admin.getPassword());
			pstmt.setString(6, admin.getRole());

			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ARSException("Can't Add New admin, as Admin Already Exists");
		}
		return true;
	}

	@Override
	public User authenticateAdmin(String email, String password) {
	    User adminInfo = new User();

		try {
			Connection conn = dbConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("loginCheckAdmin"));
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			try  {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					adminInfo.setEmailId(rs.getString("email_id"));
					adminInfo.setPassword(rs.getString("password"));
                   
					return adminInfo;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ARSException("Invalid Login Credentials, Please Enter Correctly");
		
		}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ARSException("Invalid Login Credentials, Please Enter Correctly");
			
			}
		throw new ARSException("Invalid Login Credentials, Please Enter Correctly");
		
	}
	

	@Override
	public boolean addFlights(FlightDetails flightDetails) {
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("addFlight"));) {
			pstmt.setInt(1, flightDetails.getFlightId());
			pstmt.setString(2, flightDetails.getFlightName());
			pstmt.setString(3, flightDetails.getSource());
			pstmt.setString(4, flightDetails.getDestination());
			pstmt.setInt(5, flightDetails.getNoofseatsavailable());
			pstmt.setDate(6, java.sql.Date.valueOf(flightDetails.getArrivalDate()));
			pstmt.setTime(7, java.sql.Time.valueOf(flightDetails.getArrivalTime()));
			pstmt.setDate(8, java.sql.Date.valueOf(flightDetails.getDepartureDate()));
			pstmt.setTime(9, java.sql.Time.valueOf(flightDetails.getDepartureTime()));
			

			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ARSException("Can't Add New admin, as Admin Already Exists");
		}
		return true;
	}

	@Override
	public boolean removeFlight(int flightId) {
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("removeFlight"));) {
			pstmt.setInt(1, flightId);
			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}

		} catch (Exception e) {
			throw new ARSException(e.getMessage());

		}
		throw new  ARSException("Flight Can't Be Removed or Deleted Because it is not Present in the Airline");
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("searchFlightByName"));) {
			pstmt.setString(1, flightname);
			try (ResultSet resultSet = pstmt.executeQuery();) {
				if (resultSet.next()) {
					flight=new FlightDetails(); 
					flight.setFlightId(resultSet.getInt("flight_Id"));
					flight.setFlightName(resultSet.getString("flight_name"));
					flight.setSource(resultSet.getString("source"));
					flight.setDestination(resultSet.getString("destination"));
					flight.setNoofseatsavailable(resultSet.getInt("noofseatavailable"));
					flight.setArrivalDate(resultSet.getDate("arrivaldate").toLocalDate());
				    //java.sql.Date.Valueof(LocalDate);
					flight.setArrivalDate(resultSet.getDate("arrivaldate").toLocalDate());
					flight.setArrivalTime(resultSet.getTime("arrivaltime").toLocalTime());
					flight.setDepartureDate(resultSet.getDate("departuredate").toLocalDate());
					flight.setDepartureTime(resultSet.getTime("departuretime").toLocalTime());
                    searchList.add(flight);
					return searchList;
				}
			}
		} catch (Exception e) {
			throw new ARSException(e.getMessage());
		}
		throw new ARSException("Flight is Not Found in the Airline  with the Given Flight Name");
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("searchFlightBySource"));) {
			pstmt.setString(1, source);
			try (ResultSet resultSet = pstmt.executeQuery();) {
				if (resultSet.next()) {
					flight=new FlightDetails(); 
					flight.setFlightId(resultSet.getInt("flight_Id"));
					flight.setFlightName(resultSet.getString("flight_name"));
					flight.setSource(resultSet.getString("source"));
					flight.setDestination(resultSet.getString("destination"));
					flight.setNoofseatsavailable(resultSet.getInt("noofseatavailable"));
					flight.setArrivalDate(resultSet.getDate("arrivaldate").toLocalDate());
					flight.setArrivalTime(resultSet.getTime("arrivaltime").toLocalTime());
					flight.setDepartureDate(resultSet.getDate("departuredate").toLocalDate());
					flight.setDepartureTime(resultSet.getTime("departuretime").toLocalTime());
                    searchList.add(flight);
					return searchList;
				}
			}
		} catch (Exception e) {
			throw new ARSException(e.getMessage());
		}
		throw new ARSException("Flight is Not Found in the Airline  with the Given Flight Source");
		
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("searchFlightByDestination"));) {
			pstmt.setString(1, destination);
			try (ResultSet resultSet = pstmt.executeQuery();) {
				if (resultSet.next()) {
					flight=new FlightDetails(); 
					flight.setFlightId(resultSet.getInt("flight_Id"));
					flight.setFlightName(resultSet.getString("flight_name"));
					flight.setSource(resultSet.getString("source"));
					flight.setDestination(resultSet.getString("destination"));
					flight.setNoofseatsavailable(resultSet.getInt("noofseatavailable"));
					flight.setArrivalDate(resultSet.getDate("arrivaldate").toLocalDate());
					flight.setArrivalTime(resultSet.getTime("arrivaltime").toLocalTime());
					flight.setDepartureDate(resultSet.getDate("departuredate").toLocalDate());
					flight.setDepartureTime(resultSet.getTime("departuretime").toLocalTime());
                    searchList.add(flight);
					return searchList;
				}
			}
		} catch (Exception e) {
			throw new ARSException(e.getMessage());
		}
		throw new ARSException("Flight is Not Found in the Airline  with the Given Flight Destination");
	}
	

	@Override
	public List<FlightDetails> getFlightDetails() {
		List<FlightDetails> flightList = new LinkedList<FlightDetails>();
		try (Connection conn = dbConnector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(dbConnector.getQuery("showFlights"))) {
			while (resultSet.next()) {
				FlightDetails info = new FlightDetails();
				info.setFlightId(resultSet.getInt("flight_id"));
				info.setFlightName(resultSet.getString("flight_name"));
				info.setSource(resultSet.getString("source"));
				info.setDestination(resultSet.getString("destination"));
				info.setNoofseatsavailable(resultSet.getInt("noofseatavailable"));
				info.setArrivalDate(resultSet.getDate("arrivaldate").toLocalDate());
				info.setArrivalTime(resultSet.getTime("arrivaltime").toLocalTime());
				info.setDepartureDate(resultSet.getDate("departuredate").toLocalDate());
				info.setDepartureTime(resultSet.getTime("departuretime").toLocalTime());
				
				flightList.add(info);
			}
			if (flightList.isEmpty()) {
				throw new ARSException("No Flight Present in the Airline");
			} else {
				return flightList;
			}
		} catch (Exception e) {
			throw new ARSException(e.getMessage());
		}
	}

	@Override
	public List<BookingStatus> getBookingStatus() {
		List<BookingStatus> bookingList = new LinkedList<BookingStatus>();
		try (Connection conn = dbConnector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(dbConnector.getQuery("showBooking"))) {
			while (resultSet.next()) {
				BookingStatus info = new BookingStatus();
				info.setFlightId(resultSet.getInt("flight_id"));
				info.setId(resultSet.getInt("id"));
				info.setId(resultSet.getInt("noofseatsbooked"));
				
				bookingList.add(info);
			}
			if (bookingList.isEmpty()) {
				throw new ARSException("No Booking Status Present in the Airline");
			} else {
				return bookingList;
			}
		} catch (Exception e) {
			throw new ARSException(e.getMessage());
		}
	}

}
