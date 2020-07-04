package com.jfsfeb.airlinereservationsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;
import com.jfsfeb.airlinereservationsystemjdbc.execption.ARSException;
import com.jfsfeb.airlinereservationsystemjdbc.utility.JdbcUtility;

public class AirlineDAOJDBCImp implements AirlineDAO{
	JdbcUtility dbConnector=new JdbcUtility();
	@Override
	public boolean register(User admin) {
		try (
			Connection conn = dbConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("addUser"));){
			
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
	public User authenticate(String email, String password) {
		  User user = new User();

			try(
				Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("loginCheck"));){
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				try(
					ResultSet rs = pstmt.executeQuery();){
					while (rs.next()) {
						user.setEmailId(rs.getString("email_id"));
						user.setPassword(rs.getString("password"));
	                    user.setRole(rs.getString("role"));
						return user;
					}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ARSException("Invalid Login Credentials, Please Enter Correctly or Register");
			
			}
				} catch (Exception e) {
					e.printStackTrace();
					throw new ARSException("Invalid Login Credentials, Please Enter Correctly or Register");
				
				}
			throw new ARSException("Invalid Login Credentials, Please Enter Correctly or Register");
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
		throw new ARSException("Flight is Not Found in the Airline  with the Given Flight Source and Destination");
	}

	}


