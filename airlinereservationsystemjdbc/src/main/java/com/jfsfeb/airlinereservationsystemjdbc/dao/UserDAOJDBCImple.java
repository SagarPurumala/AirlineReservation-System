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

public class UserDAOJDBCImple implements UserDAO {
	JdbcUtility dbConnector = new JdbcUtility();

	@Override
	public boolean registerUser(User user) {
		try {
			Connection conn = dbConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("addUser"));

			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmailId());
			pstmt.setLong(4, user.getMobileNumber());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getRole());

			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ARSException("Can't Add New User, as User Already Exists");
		}
		return true;
	}

	@Override
	public User authenticateUser(String emailId, String password) {
		User userInfo = new User();

		try {
			Connection conn = dbConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("loginCheckUser"));
			pstmt.setString(1, emailId);
			pstmt.setString(2, password);
			try {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					userInfo.setEmailId(rs.getString("email_id"));
					userInfo.setPassword(rs.getString("password"));

					return userInfo;
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
	public List<FlightDetails> searchFlightByName(String flightname) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("searchFlightByName"));) {
			pstmt.setString(1, flightname);
			try (ResultSet resultSet = pstmt.executeQuery();) {
				if (resultSet.next()) {
					flight = new FlightDetails();
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
					flight = new FlightDetails();
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
					flight = new FlightDetails();
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
	public BookingStatus bookRequest(BookingStatus bookingStatus) {

		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		FlightDetails flight = null;
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement(dbConnector.getQuery("searchFlightBySourceDestination"));) {
			pstmt.setString(1, source);
			pstmt.setString(2, destination);
			try (ResultSet resultSet = pstmt.executeQuery();) {
				if (resultSet.next()) {
					flight = new FlightDetails();
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

}
