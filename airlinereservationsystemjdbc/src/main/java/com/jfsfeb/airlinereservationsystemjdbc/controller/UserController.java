package com.jfsfeb.airlinereservationsystemjdbc.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystemjdbc.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;
import com.jfsfeb.airlinereservationsystemjdbc.execption.ARSException;
import com.jfsfeb.airlinereservationsystemjdbc.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemjdbc.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserController {
public static void userOperations() {
		
		int checkId = 0;
		String checkName = null;
		long checkMobile = 0;
		String checkEmail = null;
		String checkPassword = null;
		String role=null;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		UserService service1 = AirlineFactory.getUserServiceImplInstance();
		do {
			try {
				System.out.println("<--------------------------------------------------------------------->");
				log.info("[1] USER REGISTER");
				log.info("[2] USER LOGIN");
				log.info("[3] EXIT");
				System.out.println("<--------------------------------------------------------------------->");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					try {
					log.info("Enter ID to Register as USER : ");
					checkId = scanner.nextInt();

					log.info("Enter Name to Register : ");
					checkName = scanner.next();

					log.info("Enter MobileNumber to Register : ");
					checkMobile = scanner.nextLong();

					log.info("Enter Email to Register : ");
					checkEmail = scanner.next();

					log.info("Enter Password :");
					checkPassword = scanner.next();
					
					log.info("Enter Role  :");
					role = scanner.next();

					User bean1 = new User();
					bean1.setId(checkId);
					bean1.setName(checkName);
					bean1.setMobileNumber(checkMobile);
					bean1.setEmailId(checkEmail);
					bean1.setPassword(checkPassword);
					bean1.setRole(role);

					boolean check = service1.registerUser(bean1);
					if (check) {
						log.info("Registered Successfully");
					} else {
						log.info("Already registered");
					}
					break;
					 }catch (InputMismatchException e) {
		      				log.error("Invalid entry ");
		    				scanner.nextLine();
		    				break;
		    			}
		                  catch (ARSException e) {
							log.info(e.getMessage());
							break;
						}

				case 2:
					log.info("Enter registered email to login : ");
					String email = scanner.next();
					log.info("Enter registered Password to login : ");
					String password = scanner.next();
					try {

						User user = service1.authenticateUser(email, password);
						if (user != null) {
							log.info("Logged in Successfully");
							do {
								try {
									log.info("<--------------------------------------------------------------------->");
									log.info("[1]  SEARCH FLIGHT BY SOURCE");
									log.info("[2]  SEARCH FLIGHT BY DESTINATION");
									log.info("[3] SEARCH FLIGHT BY NAME");
									log.info("[4]  VIEW ALL FLIGHTDETAILS");
									log.info("[5] SEARCH FLIGHT BY SOURCE AND DESTINATION");
									log.info("[6]  BOOK THE FLIGHT");
									log.info("[7]  LOGOUT");
									log.info("<--------------------------------------------------------------------->");
									int choice2 = scanner.nextInt();
									switch (choice2) {
									case 1:
										log.info("Search Flight Details by Source : ");
										String source = scanner.next();

										FlightDetails bean3 = new FlightDetails();
										bean3.setSource(source);
										List<FlightDetails> flightSource1 = service1.searchFlightBySource(source);
										log.info(
												"<--------------------------------------------------------------------->");
										log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s","FlightId",
												"Flight Name", "Source", "Destination", "Arrival Date","Arrival Time",
												"Departure Date","Departure Time", "NoofSeatAvailable"));
										for (FlightDetails flightBean : flightSource1) {
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
												log.info("No Flights are available with this Source");
											}
										}
										break;

									case 2:

										log.info("Search flight by Destination : ");
										String destination = scanner.next();

										FlightDetails bean4 = new FlightDetails();
										bean4.setDestination(destination);
										List<FlightDetails> flightDestination1 = service1
												.searchFlightByDestination(destination);
										log.info(
												"<<--------------------------------------------------------------------->>");
										log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s","FlightId",
												"Flight Name", "Source", "Destination", "Arrival Date","Arrival Time",
												"Departure Date","Departure Time", "NoofSeatAvailable"));
										for (FlightDetails flightBean : flightDestination1) {
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
										log.info(" SEARCH FLIGHT BY NAME : ");
										String name = scanner.next();

										FlightDetails bean5 = new FlightDetails();
										bean5.setFlightName(name);
										;
										List<FlightDetails> fname = service1.searchFlightByName(name);
										log.info(
												"<--------------------------------------------------------------------->");
										log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s","FlightId",
												"Flight Name", "Source", "Destination", "Arrival Date","Arrival Time",
												"Departure Date","Departure Time", "NoofSeatAvailable"));
										for (FlightDetails flightBean : fname) {
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
												log.info("No Flights are available with this Flight Name");
											}
										}
										break;
									case 4:
										List<FlightDetails> info = service1.getFlightDetails();
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
									case 5:
										log.info("Search flight by Source : ");
										String source1 = scanner.next();
										log.info("Search flight by Destination : ");
										String destination1 = scanner.next();
										FlightDetails bean6 = new FlightDetails();
										bean6.setDestination(source1);
										bean6.setDestination(destination1);
										List<FlightDetails> flightSourceToDestination = service1
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
									case 6:
										log.info("Search flight by Source : ");
										String source2 = scanner.next();
										log.info("Search flight by Destination : ");
										String destination2 = scanner.next();
										FlightDetails bean7 = new FlightDetails();
										bean7.setDestination(source2);
										bean7.setDestination(destination2);
										List<FlightDetails> flightSourceToDestination1 = service1
												.searchFlightBySourceAndDestination(source2, destination2);
										log.info(
												"<<--------------------------------------------------------------------->>");
										log.info(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s","FlightId",
												"Flight Name", "Source", "Destination", "Arrival Date","Arrival Time",
												"Departure Date","Departure Time", "NoofSeatAvailable"));
										for (FlightDetails flightBean : flightSourceToDestination1) {
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
										do {
											try {
												log.info(
														"<--------------------------------------------------------------------->");
												log.info("[1]  PROCEED TO BOOK");
												log.info("[2]  LOGOUT");

												log.info(
														"<--------------------------------------------------------------------->");
												int choice3 = scanner.nextInt();
												switch (choice3) {
												case 1:
													try {
														log.info("Enter User Id : ");
														int userId2 = scanner.nextInt();
														User userBean = new User();
														userBean.setId(userId2);
														log.info("Enter Flight Id : ");
														int flightId2 = scanner.nextInt();
														FlightDetails flightDetails1 = new FlightDetails();
														flightDetails1.setFlightId(flightId2);
														log.info("Enter No of seats : ");
														int seats = scanner.nextInt();
														BookingStatus bookingStatus = new BookingStatus();
														bookingStatus.setNoofseatsbooked(seats);
														bookingStatus.setId(userId2);
														bookingStatus.setFlightId(flightId2);
														try {
															BookingStatus request = service1.bookRequest(bookingStatus);
															log.info("Request placed to Airline Management ");
															log.info(
																	"<--------------------------------------------------------------------->");
															log.info(String.format(
																	"%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
																	"FlightId", "FlightName", "UserID", "UserName",
																	"Source", "Destination", "ArrivalDateTime",
																	"DepartureDateTime", "NoofSeatBooked"));
															;
															log.info(String.format(
																	"%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
																	request.getFlightDetails().getFlightId(),
																	request.getFlightDetails().getFlightName(),
																	request.getUser().getId(),
																	request.getUser().getName(),
																	request.getFlightDetails().getSource(),
																	request.getFlightDetails().getDestination(),
																	//request.getFlightDetails().getArrivalDateTime(),
																	//request.getFlightDetails().getDepartureDateTime(),
																	bookingStatus.getNoofseatsbooked()));
														} catch (Exception e) {
															log.info("Invalid Request of booking");
														}
													} catch (InputMismatchException e) {
														log.error("Invalid entry  ");
														scanner.nextLine();
													} catch (Exception e) {
														log.info("Invalid request");
													}
													break;
												case 2:
													SubAirlineController.airlineOperations();
												default:
													log.error("Invalid entry please provide 1 or 2 ");
													break;
												}
											} catch (InputMismatchException e) {
												log.error("Invalid entry please provide 1 or 2 ");
												scanner.nextLine();
											} catch (ARSException e) {
												log.info(e.getMessage());
											}
										} while (true);

									case 7:
										UserController.userOperations();

									default:
										log.error("Invalid entry please provide 1 or 2 or 3 or 4 or 5 or 6 or 7");
										break;
									}
								} catch (InputMismatchException e) {
									System.err.println("Invalid entry please provide 1 or 2 or 3 or 4 or 5 or 6 or 7");
									scanner.nextLine();
								} catch (ARSException e) {
									log.info(e.getMessage());
								}

							} while (true);
						}
					} catch (ARSException e) {
						log.info(e.getMessage());
					}
					break;
				case 3:
					SubAirlineController.airlineOperations();
					break;

				default:
					log.info("Invalid Choice");
					log.error("Choice must be 1 or 2 or 3");
					break;
				}
			} catch (InputMismatchException e) { // if we give string in 1 n 2 n 3
				log.error("Invalid entry please provide 1 or 2 or 3");
				scanner.nextLine();
			}
		} while (true);
	}// close of userOperations method


}
