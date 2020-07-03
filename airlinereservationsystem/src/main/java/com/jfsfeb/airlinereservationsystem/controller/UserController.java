package com.jfsfeb.airlinereservationsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystem.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;
import com.jfsfeb.airlinereservationsystem.exception.ARSException;
import com.jfsfeb.airlinereservationsystem.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystem.service.UserService;


import lombok.extern.log4j.Log4j;

@Log4j
public class UserController {
	public static void userOperations() {
		
		int checkId = 0;
		String checkName = null;
		long checkMobile = 0;
		String checkEmail = null;
		String checkPassword = null;
		
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

					UserInfo bean1 = new UserInfo();
					bean1.setUserId(checkId);
					bean1.setUserName(checkName);
					bean1.setMobileNumber(checkMobile);
					bean1.setEmailId(checkEmail);
					bean1.setPassword(checkPassword);

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

						UserInfo user = service1.authenticateUser(email, password);
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
										log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
												"FlightName", "Source", "Destination", "ArrivalDateTime",
												"DepartureDateTime", "NoofSeatAvailable"));
										for (FlightDetails flightBean : flightSource1) {
											if (flightBean != null) {
												log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s",
														flightBean.getFlightId(), flightBean.getFlightName(),
														flightBean.getSource(), flightBean.getDestination(),
														flightBean.getArrivalDateTime(),
														flightBean.getDepartureDateTime(),
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
										log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
												"FlightName", "Source", "Destination", "ArrivalDateTime",
												"DepartureDateTime", "NoofSeatAvailable"));
										for (FlightDetails flightBean : flightDestination1) {
											if (flightBean != null) {
												log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s",
														flightBean.getFlightId(), flightBean.getFlightName(),
														flightBean.getSource(), flightBean.getDestination(),
														flightBean.getArrivalDateTime(),
														flightBean.getDepartureDateTime(),
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
										log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
												"FlightName", "Source", "Destination", "ArrivalDateTime",
												"DepartureDateTime", "NoofSeatAvailable"));
										for (FlightDetails flightBean : fname) {
											if (flightBean != null) {
												log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s",
														flightBean.getFlightId(), flightBean.getFlightName(),
														flightBean.getSource(), flightBean.getDestination(),
														flightBean.getArrivalDateTime(),
														flightBean.getDepartureDateTime(),
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
										log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
												"FlightName", "Source", "Destination", "ArrivalDateTime",
												"DepartureDateTime", "NoofSeatAvailable"));
										for (FlightDetails flightBean : info) {
											if (flightBean != null) {
												log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s",
														flightBean.getFlightId(), flightBean.getFlightName(),
														flightBean.getSource(), flightBean.getDestination(),
														flightBean.getArrivalDateTime(),
														flightBean.getDepartureDateTime(),
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
										log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
												"FlightName", "Source", "Destination", "ArrivalDateTime",
												"DepartureDateTime", "NoofSeatAvailable"));
										for (FlightDetails flightBean : flightSourceToDestination) {
											if (flightBean != null) {
												log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s",
														flightBean.getFlightId(), flightBean.getFlightName(),
														flightBean.getSource(), flightBean.getDestination(),
														flightBean.getArrivalDateTime(),
														flightBean.getDepartureDateTime(),
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
										log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
												"FlightName", "Source", "Destination", "ArrivalDateTime",
												"DepartureDateTime", "NoofSeatAvailable"));
										for (FlightDetails flightBean : flightSourceToDestination1) {
											if (flightBean != null) {
												log.info(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s",
														flightBean.getFlightId(), flightBean.getFlightName(),
														flightBean.getSource(), flightBean.getDestination(),
														flightBean.getArrivalDateTime(),
														flightBean.getDepartureDateTime(),
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
														UserInfo userBean = new UserInfo();
														userBean.setUserId(userId2);
														log.info("Enter Flight Id : ");
														int flightId2 = scanner.nextInt();
														FlightDetails flightDetails1 = new FlightDetails();
														flightDetails1.setFlightId(flightId2);
														log.info("Enter No of seats : ");
														int seats = scanner.nextInt();
														BookingStatus bookingStatus = new BookingStatus();
														bookingStatus.setNoofSeatsBooked(seats);
														try {
															BookingStatus request = service1.bookRequest(userBean,
																	flightDetails1);
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
																	request.getUserInfo().getUserId(),
																	request.getUserInfo().getUserName(),
																	request.getFlightDetails().getSource(),
																	request.getFlightDetails().getDestination(),
																	request.getFlightDetails().getArrivalDateTime(),
																	request.getFlightDetails().getDepartureDateTime(),
																	bookingStatus.getNoofSeatsBooked()));
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
													SubAirlineMain.airlineOperations();
												default:
													log.error("Invalid entry please choose above option");
													break;
												}
											} catch (InputMismatchException e) {
												log.error("Invalid entry please choose above option");
												scanner.nextLine();
											} catch (ARSException e) {
												log.info(e.getMessage());
											}
										} while (true);

									case 7:
										UserController.userOperations();

									default:
										log.error("Invalid entry please choose above option");
										break;
									}
								} catch (InputMismatchException e) {
									System.err.println("Invalid entry please choose above option");
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
					SubAirlineMain.airlineOperations();
					break;

				default:
					log.info("Invalid Choice");
					log.error("Invalid entry please choose above option");
					break;
				}
			} catch (InputMismatchException e) { // if we give string in 1 n 2 n 3
				log.error("Invalid entry please choose above option");
				scanner.nextLine();
			}
		} while (true);
	}// close of userOperations method

}// close of UserController class
