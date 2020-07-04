package com.jfsfeb.airlinereservationsystemcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.airlinereservationsystemcollection.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemcollection.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemcollection.dto.UserInfo;
import com.jfsfeb.airlinereservationsystemcollection.exception.ARSException;
import com.jfsfeb.airlinereservationsystemcollection.repository.AirlineRepository;

public class UserDAOImple implements UserDAO {

	@Override
	public boolean registerUser(UserInfo user) {
		// TODO Auto-generated method stub
		for (UserInfo u1 : AirlineRepository.USER_INFOS) {
			if ((u1.getEmailId()).equals(user.getEmailId())) {
				return false;
			}
		}
		AirlineRepository.USER_INFOS.add(user);
		return true;
	}

	@Override
	public UserInfo authenticateUser(String emailId, String password) {
		// TODO Auto-generated method stub
		for (UserInfo u2 : AirlineRepository.USER_INFOS) {
			if ((u2.getEmailId().equals(emailId)) && (u2.getPassword().equals(password))) {
				return u2;
			}
		}
		throw new ARSException("Invalid Credentials");

	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightName) {
		// TODO Auto-generated method stub
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			String retrievedFname = retrievedFlight.getFlightName();
			if (flightName.equals(retrievedFname)) {
				searchList.add(retrievedFlight);
				return searchList;
			}
		}
		if (searchList.size() == 0) {
			throw new ARSException("FlightName not found in airline reservation system");
		} else {
			return searchList;
		}
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		// TODO Auto-generated method stub
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			String retrievedFSource = retrievedFlight.getSource();
			if (source.equals(retrievedFSource)) {
				searchList.add(retrievedFlight);
			}
		}
		if (searchList.size() == 0) {
			throw new ARSException("No flight with given Source ");
		} else {
			return searchList;
		}
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		// TODO Auto-generated method stub
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			String retrievedFDestination = retrievedFlight.getDestination();
			if (destination.equals(retrievedFDestination)) {
				searchList.add(retrievedFlight);
			}
		}
		if (searchList.size() == 0) {
			throw new ARSException("No flight with given destination");
		} else {
			return searchList;
		}
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return AirlineRepository.FLIGHT_DETAILS;
	}

	@Override
	public BookingStatus bookRequest(UserInfo user,FlightDetails flight) {
		// TODO Auto-generated method stub
		       boolean flag = false, 
				isRequestExists = false;
          		BookingStatus bookingStatus = new BookingStatus();
                 UserInfo userInfo2 = new UserInfo();
                 FlightDetails flightDetails2 = new FlightDetails();
     			for (BookingStatus bookingStatus1 : AirlineRepository.STATUS) {
					if (flight.getFlightId() ==  bookingStatus1.getFlightDetails().getFlightId()) {
						isRequestExists = true;
					}
				} 
     			if(!isRequestExists) {
     				for (UserInfo userBean :  AirlineRepository.USER_INFOS) {
						if (user.getUserId() == userBean.getUserId()) {
							for (FlightDetails flight1 : AirlineRepository.FLIGHT_DETAILS) {
								if (flight1.getFlightId() == flight.getFlightId()) {
									userInfo2= userBean;
									flightDetails2 = flight1;
									
										flag = true;
								     }
									
							       }
							   }
							    
							
     				}
				
              
					if (flag == true) {
						bookingStatus.setFlightDetails(flightDetails2);;
						
						bookingStatus.setUserInfo(userInfo2);;
						AirlineRepository.STATUS.add(bookingStatus);
					return bookingStatus;
					}
				}
		throw new ARSException("Invalid request or you cannot request that book");
		
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		List<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			String retrievedFDestination = retrievedFlight.getDestination();
			String retrievedFSource=retrievedFlight.getSource();
			if (source.equals(retrievedFSource)&&destination.equals(retrievedFDestination)) {
				searchList.add(retrievedFlight);
			}
		}
		if (searchList.size() == 0) {
			throw new ARSException("No flight with given Source and destination");
		} else {
			return searchList;
		}
	}

	}
