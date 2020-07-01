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
import com.jfsfeb.airlinereservationsystemjdbc.execption.ARSException;
import com.jfsfeb.airlinereservationsystemjdbc.utility.JdbcUtility;

public class UserDAOJDBCImple implements UserDAO {
	JdbcUtility dbConnector = new JdbcUtility();

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
		int userId = bookingStatus.getId();

		try {
			Connection conn = dbConnector.getConnection();
			PreparedStatement getFlightPstmt = conn.prepareStatement(dbConnector.getQuery("getFlight"));
			
			getFlightPstmt.setInt(1, bookingStatus.getFlightId());
			
			try (ResultSet getReqSet = getFlightPstmt.executeQuery();) {
				while (getReqSet.next()) {
					int bookFlightId = getReqSet.getInt("flight_id");

					if (bookingStatus.getFlightId() == bookFlightId) {

						try {
							Connection conne = dbConnector.getConnection();
							PreparedStatement getUserPstmt = conne.prepareStatement(dbConnector.getQuery("getUser"));
							getUserPstmt.setInt(1, bookingStatus.getId());
							try (ResultSet getUser = getUserPstmt.executeQuery();) {
								while (getUser.next()) {
									int user = getUser.getInt("id");
									
									if (userId == user) {
									
										try {
											Connection conn1 = dbConnector.getConnection();
											PreparedStatement getRequestPstmt = conn1.prepareStatement(dbConnector.getQuery("requestBooked"));
											getRequestPstmt.setInt(1, bookingStatus.getTicketId());
											getRequestPstmt.setInt(2, bookingStatus.getId());
										getRequestPstmt.setInt(3, bookingStatus.getFlightId());
										getRequestPstmt.setInt(4, bookingStatus.getNoofseatsbooked());
										
										getRequestPstmt.executeUpdate();
										return bookingStatus;
										
										
	
										} catch (Exception e) {
											throw new ARSException("Can't request flight");
										}
										
										
										
										
									}
								}
							}
						} catch (Exception e) {
							throw new ARSException(e.getMessage());
						}
					}
				}
			}
		} catch (ARSException e) {
			throw new ARSException(e.getMessage());
		} catch (Exception e) {
			throw new ARSException(e.getMessage());
		}
		return null;
	}

//			try (ResultSet getReqSet = getFlightPstmt.executeQuery();) {
//				if (getReqSet.next()) {
//					int requestFlightId = getReqSet.getInt("flight_id");
//					getRequestPstmt.setInt(1, requestFlightId);
//					try (ResultSet getUserSet = getUserPstmt.executeQuery();) {
//						if (getUserSet.next()) {
//							int requestUserId = getReqSet.getInt("id");
//							getRequestPstmt.setInt(1, requestUserId);
//						} else {
//							throw new ARSException("Request not Found with Matching UserId ");
//						}
//					} catch (Exception e) {
//						throw new ARSException(e.getMessage());
//					}
//				} else {
//					throw new ARSException("Request not Found with Matching FlightId ");
//				}
//
//			} catch (Exception e) {
//				throw new ARSException(e.getMessage());
//			}
//		} catch (Exception e) {
//			throw new ARSException(e.getMessage());
//		}

//	}

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
