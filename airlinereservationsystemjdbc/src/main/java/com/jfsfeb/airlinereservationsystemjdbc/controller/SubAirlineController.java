package com.jfsfeb.airlinereservationsystemjdbc.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;
import com.jfsfeb.airlinereservationsystemjdbc.execption.ARSException;
import com.jfsfeb.airlinereservationsystemjdbc.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemjdbc.service.AirlineService;

import lombok.extern.log4j.Log4j;

@Log4j
public class SubAirlineController {
	

public static void airlineOperations() {
	
	int checkId = 0;
	String checkName = null;
	long checkMobile = 0;
	String checkEmail = null;
	String checkPassword = null;
	String role=null;
	String email = null;
	String password = null;
   

    AirlineService service =AirlineFactory.getAirlineServiceImplInstance();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				log.info(
						"<----------------------<<< WELCOME TO AIRLINE RESERVATION SYSTEM >>>--------------------->");
				log.info("[1] VIEW ALL FLIGHTDETAILS");
				log.info("[2] SEARCH FLIGHT BY SOURCE AND DESTINATION");
				log.info("[3] IF YOUR ARE ALREADY REGISTERED THEN LOGIN");
				log.info("[4] IF YOUR ARE NEW USER REGISTER");
				log.info("<--------------------------------------------------------------------->");
				int i = scanner.nextInt();
				
				switch (i) {
				case 1:
					List<FlightDetails> info = service.getFlightDetails();
					log.info(
							"<--------------------------------------------------------------------->");
					log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s","FlightId",
							"Flight Name", "Source", "Destination", "Arrival Date","Arrival Time",
							"Departure Date","Departure Time", "NoofSeatAvailable"));
					for (FlightDetails flightBean : info) {
						if (flightBean != null) {
							log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
									flightBean.getFlightId(), flightBean.getFlightName(),
									flightBean.getSource(), flightBean.getDestination(),
									java.sql.Date.valueOf(flightBean.getArrivalDate()),
									java.sql.Time.valueOf(flightBean.getArrivalTime()),
									java.sql.Date.valueOf(flightBean.getDepartureDate()),
									java.sql.Time.valueOf(flightBean.getDepartureTime()),
									flightBean.getNoofseatsavailable()));
						} else {
							log.info("No Flight are available in the Flight Details");
						}
					}
					break;
				case 2:
					log.info("Search flight by Source : ");
					String source1 = scanner.next();
					log.info("Search flight by Destination : ");
					String destination1 = scanner.next();
					FlightDetails bean6 = new FlightDetails();
					bean6.setDestination(source1);
					bean6.setDestination(destination1);
					List<FlightDetails> flightSourceToDestination = service
							.searchFlightBySourceAndDestination(source1, destination1);
					log.info(
							"<<--------------------------------------------------------------------->>");
					log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s","FlightId",
							"Flight Name", "Source", "Destination", "Arrival Date","Arrival Time",
							"Departure Date","Departure Time", "NoofSeatAvailable"));
					for (FlightDetails flightBean : flightSourceToDestination) {
						if (flightBean != null) {
							log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
									flightBean.getFlightId(), flightBean.getFlightName(),
									flightBean.getSource(), flightBean.getDestination(),
									java.sql.Date.valueOf(flightBean.getArrivalDate()),
									java.sql.Time.valueOf(flightBean.getArrivalTime()),
									java.sql.Date.valueOf(flightBean.getDepartureDate()),
									java.sql.Time.valueOf(flightBean.getDepartureTime()),
									flightBean.getNoofseatsavailable()));
						} else {
							log.info("No Flights are available with this Destination");
						}
					}
					break;
				case 3:
					log.info("Enter registered email to login : ");
					email = scanner.next();
					log.info("Enter registered Password to login : ");
					password = scanner.next();

					try {
						User authBean = service.authenticate(email, password);
						if (authBean != null) {
							String roleAdmin="admin";
							String roleUser="user";
							if(authBean.getRole().equals(roleAdmin)) {
								AdminController.adminOperations();
							}
							else if(authBean.getRole().equals(roleUser)) {
								UserController.userOperations();
							}
						} else {
							log.info("emailid and password should not be null ");
						}
					} catch (ARSException e) {
						log.info(e.getMessage());
					}
					break;
				case 4:
					   try {
							log.info("Enter ID to Register : ");
							checkId = scanner.nextInt();
							log.info("Enter Name to Register : ");
							checkName = scanner.next();
							log.info("Enter MobileNumber to Register : ");
							checkMobile = scanner.nextLong();
							log.info("Enter Email to Register : ");
							checkEmail = scanner.next();
							log.info("Enter Password :");
							checkPassword = scanner.next();
							log.info("Enter Role :");
							role = scanner.next();
							User bean = new User();
							bean.setId(checkId);
							bean.setName(checkName);
							bean.setMobileNumber(checkMobile);
							bean.setEmailId(checkEmail);
							bean.setPassword(checkPassword);
							bean.setRole(role);

							boolean check = service.register(bean);
							if (check) {
								log.info("You have registered Successfully");
							} else {
								log.info("Already registered");
							}
							break;
		                  }catch (InputMismatchException e) {
		      				log.error("Invalid entry ");
		    				scanner.next();
		    				break;
		    			}
		                  catch (ARSException e) {
							log.info(e.getMessage());
							break;
						}


				default:
					log.info("Invalid Choice");
					log.error("Choice must be 1 or 2 or 3 or 4");
					break;
				}
			} catch (InputMismatchException e) { //// if we give string in 1 n 2 n 3 n 4
				log.error("Invalid entry please provide 1 or 2 or 3 or 4");
				scanner.nextLine();
			}
			catch (ARSException e) {
				log.info(e.getMessage());
				
			}catch (Exception e) {
				log.error("Invalid Credentials");
			}
			 
		} while (true);
	}

}
