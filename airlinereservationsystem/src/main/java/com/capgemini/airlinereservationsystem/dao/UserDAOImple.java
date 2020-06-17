package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dto.BookingStatus;
import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;
import com.capgemini.airlinereservationsystem.exception.ARSException;
import com.capgemini.airlinereservationsystem.repository.AirlineRepository;

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
	public ArrayList<FlightDetails> searchFlightByName(String flightName) {
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
			throw new ARSException("Flight not found");
		} else {
			return searchList;
		}
	}

	@Override
	public ArrayList<FlightDetails> searchFlightBySource(String source) {
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
			throw new ARSException("Flight not found");
		} else {
			return searchList;
		}
	}

	@Override
	public ArrayList<FlightDetails> searchFlightByDestination(String destination) {
		// TODO Auto-generated method stub
		ArrayList<FlightDetails> searchList = new ArrayList<FlightDetails>();
		for (int i = 0; i <= AirlineRepository.FLIGHT_DETAILS.size() - 1; i++) {
			FlightDetails retrievedFlight = AirlineRepository.FLIGHT_DETAILS.get(i);
			String retrievedFDestination = retrievedFlight.getDestination();
			if (destination.equals(retrievedFDestination)) {
				searchList.add(retrievedFlight);
			}
		}
		if (searchList.size() == 0) {
			throw new ARSException("Flight not found");
		} else {
			return searchList;
		}
	}

	@Override
	public ArrayList<FlightDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return AirlineRepository.FLIGHT_DETAILS;
	}

	@Override
	public BookingStatus bookRequest(UserInfo user,FlightDetails fSource, FlightDetails fDestination) {
		// TODO Auto-generated method stub
		       boolean flag = false, 
				isRequestExists = false;
          		BookingStatus bookingStatus = new BookingStatus();
                 UserInfo userInfo2 = new UserInfo();
                 FlightDetails flightDetails2 = new FlightDetails();
				for (BookingStatus bookingStatus2 : AirlineRepository.STATUS) {
 			       if (fSource.getSource() == bookingStatus2.getFlightDetails().getSource()) {
 			    	      
 			    		  isRequestExists = true; 
				    }
                }
				for (BookingStatus bookingStatus3 : AirlineRepository.STATUS) {
				 if(fDestination.getDestination()==bookingStatus3.getFlightDetails().getDestination()) {
		    		  isRequestExists = true; 
		    	   }
				}
                 if (!isRequestExists) {
               	for (UserInfo userBean : AirlineRepository.USER_INFOS) {
  					if (user.getUserId() == userBean.getUserId()) {
							for (FlightDetails filght1 : AirlineRepository.FLIGHT_DETAILS) {
							if (filght1.getSource() == filght1.getSource()&&filght1.getDestination()==filght1.getDestination()) {
							    userInfo2= userBean;
								flightDetails2 = filght1;
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

}
