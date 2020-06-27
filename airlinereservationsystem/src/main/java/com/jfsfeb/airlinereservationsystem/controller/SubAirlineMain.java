package com.jfsfeb.airlinereservationsystem.controller;

import java.time.LocalDateTime;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystem.dto.AdminInfo;
import com.jfsfeb.airlinereservationsystem.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.UserInfo;
import com.jfsfeb.airlinereservationsystem.exception.ARSException;

import com.jfsfeb.airlinereservationsystem.service.AdminService;
import com.jfsfeb.airlinereservationsystem.service.AdminServiceImple;
import com.jfsfeb.airlinereservationsystem.service.UserService;
import com.jfsfeb.airlinereservationsystem.service.UserServiceImple;
import com.jfsfeb.airlinereservationsystem.validation.Validation;

import lombok.extern.log4j.Log4j;
@Log4j
public class SubAirlineMain {
	public static void airlineOperations() {

		boolean flag = false;
		int checkId = 0;
		String checkName = null;
		long checkMobile = 0;
		String checkMobileno = null;
		String checkEmail = null;
		String checkPassword = null;
		int flightId = 0;
		String flightName = null;
		String flightSource = null;
		String flightDestination = null;
		int noofSeatsAvailable = 0;
		LocalDateTime arrivalDateTime = null;
		LocalDateTime departureDateTime = null;
		
		Validation validation = new Validation();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				log.info(
						"<----------------------<<< WELCOME TO AIRLINE RESERVATION SYSTEM >>>--------------------->");
				log.info("[1] ADMIN PAGE");
				log.info("[2] USER PAGE");
				log.info("<--------------------------------------------------------------------->");
				int i = scanner.nextInt();
				switch (i) {
				case 1:
					AdminService service = new AdminServiceImple();
					do {
						try {
							System.out
									.println("<--------------------------------------------------------------------->");
							log.info("[1] ADMINISTRATION REGISTER");
							log.info("[2] ADMINISTRATION LOGIN");
							log.info("[3] EXIT");
							System.out
									.println("<--------------------------------------------------------------------->");
							int choice = scanner.nextInt();
							switch (choice) {

							case 1:
								do {
									try {
										log.info("Enter ID to Register as ADMIN : ");
										checkId = scanner.nextInt();
										validation.validatedId(checkId);
										flag = true;
									} catch (InputMismatchException e) {
										log.error("ID should consist of only digits");
										flag = false;
										scanner.next();
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Name to Register : ");
										checkName = scanner.next();
										validation.validatedName(checkName);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Name should consists of only Alphabates");
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter MobileNumber to Register : ");
										checkMobile = scanner.nextLong();
										validation.validatedMobile(checkMobile);
										flag = true;
									} catch (InputMismatchException e) {
										log.error("Mobile Number  should consists of only numbers");
										flag = false;
										scanner.next();
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Email to Register : ");
										checkEmail = scanner.next();
										//validation.validatedEmail(checkEmail);
										System.out.println(validation.validatedEmail(checkEmail));
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error(
												"Enter proper email such that it should consist of numbers and alphabets");
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Password :");
										checkPassword = scanner.next();
										validation.validatedPassword(checkPassword);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Password doesnt accept spaces ");
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);

								AdminInfo bean = new AdminInfo();
								bean.setId(checkId);
								bean.setName(checkName);
								bean.setMobileNo(checkMobile);
								bean.setEmailId(checkEmail);
								bean.setPassword(checkPassword);

								boolean check = service.registerAdmin(bean);
								if (check) {
									log.info("You have registered Successfully");
								} else {
									log.info("Already registered");
								}
								break;

							case 2:
								log.info("Enter registered email to login : ");
								String email = scanner.next();
								
								log.info("Enter registered Password to login : ");
								String password = scanner.next();
								try {
									
									AdminInfo authBean = service.authenticateAdmin(email, password);
									
									log.info("You have logged in successfully");
									log.info("Now you can perform the following operations:-");
									do {
										try {
											log.info(
													"<--------------------------------------------------------------------->");
											log.info("[1]  ADD FLIGHTS");
											log.info("[2]  SEARCH FLIGHT BY SOURCE");
											log.info("[3]  SEARCH FLIGHT BY DESTINATION");
											log.info("[4]  SEARCH FLIGHT BY NAME");
											log.info("[5]  REMOVE FLIGHT");
											log.info("[6]  VIEW ALL FLIGHTDETAILS");
											// log.info("[7] ISSUE FLIGHTDETAILS");
											// log.info("[8] VIEW ALL USER");

											log.info("[9] LOGOUT");
											log.info(
													"<--------------------------------------------------------------------->");
											int choice1 = scanner.nextInt();
											switch (choice1) {
											case 1:

												do {

													try {
														log.info("Enter FlightID to add : ");
														flightId = scanner.nextInt();
														validation.validatedId(flightId);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														log.error("Id should contains only digits");
														scanner.next();
													} catch (ARSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);
												do {

													try {
														log.info("Enter FlightName : ");
														flightName = scanner.next();
														validation.validatedName(flightName);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														log.error("FlightName should contains only Alphabets");
													} catch (ARSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);
												do {
													log.info("Enter Source : ");
													flightSource = scanner.next();
													try {
														validation.validatedName(flightSource);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														log.error("Source should contains only Alphabates");
													} catch (ARSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);
												do {

													try {
														log.info("Enter Destination : ");
														flightDestination = scanner.next();
														validation.validatedName(flightDestination);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err
																.println("Destination should contains only Alphabates");
													} catch (ARSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);
												do {

													try {
														System.out
																.println("Enter No.of seat Available in the Flight : ");
														noofSeatsAvailable = scanner.nextInt();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														log.error(
																"noofSeatsAvailable should contains only digits");
														scanner.next();
													} catch (ARSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);
												do {
													log.info("Enter  Flight Arrival Date Time : ");
													
													try {
														arrivalDateTime = LocalDateTime.of(scanner.nextInt(),
																scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
																scanner.nextInt());
                                                        
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														log.error("its should contains only digits");
														scanner.next();
													} catch (ARSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);
												do {
													log.info("Enter  Flight departure Date Time : ");
													
													try {
														departureDateTime = LocalDateTime.of(scanner.nextInt(),
																scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
																scanner.nextInt());
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														log.error("its should contains only digits ");
														scanner.next();
													} catch (ARSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);
												FlightDetails bean1 = new FlightDetails();
												bean1.setFlightId(flightId);
												bean1.setFlightName(flightName);
												bean1.setSource(flightSource);
												bean1.setDestination(flightDestination);
												bean1.setNoofseatsavailable(noofSeatsAvailable);
												bean1.setArrivalDateTime(arrivalDateTime);
												bean1.setDepartureDateTime(departureDateTime);
												boolean check2 = service.addFlights(bean1);
												if (check2) {
													log.info("Flight added of id = " + flightId);
												} else {
													log.info("Flight already exist of id = " + flightId);
												}
												break;
											case 2:
												log.info("Search Flight Details by Source : ");
												String source = scanner.next();

												FlightDetails bean3 = new FlightDetails();
												bean3.setSource(source);
												List<FlightDetails> flightSource1 = service
														.searchFlightBySource(source);
												log.info(
														"<--------------------------------------------------------------------->");
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"Flight Name", "Source", "Destination", "Arrival Date Time",
														"Departure Date Time", "NoofSeatAvailable"));
												for (FlightDetails flightBean : flightSource1) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
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
											case 3:
												log.info("Search flight by Destination : ");
												String destination = scanner.next();

												FlightDetails bean4 = new FlightDetails();
												bean4.setDestination(destination);
												List<FlightDetails> flightDestination1 = service
														.searchFlightByDestination(destination);
												log.info(
														"<<--------------------------------------------------------------------->>");
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "Flight Id",
														"Flight Name", "Source", "Destination", "Arrival Date Time",
														"Departure Date Time", "NoofSeatAvailable"));
												for (FlightDetails flightBean : flightDestination1) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
																flightBean.getFlightId(), flightBean.getFlightName(),
																flightBean.getSource(), flightBean.getDestination(),
																flightBean.getArrivalDateTime(),
																flightBean.getDepartureDateTime(),
																flightBean.getNoofseatsavailable()));
													} else {
														log.info(
																"No Flights are available with this Destination");
													}
												}
												break;
											case 4:
												log.info(" SEARCH FLIGHT BY NAME : ");
												String name = scanner.next();

												FlightDetails bean5 = new FlightDetails();
												bean5.setFlightName(name);
												;
												List<FlightDetails> fname = service.searchFlightByName(name);
												log.info(
														"<--------------------------------------------------------------------->");
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName", "Source", "Destination", "ArrivalDateTime",
														"DepartureDateTime", "NoofSeatAvailable"));
												for (FlightDetails flightBean : fname) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
																flightBean.getFlightId(), flightBean.getFlightName(),
																flightBean.getSource(), flightBean.getDestination(),
																flightBean.getArrivalDateTime(),
																flightBean.getDepartureDateTime(),
																flightBean.getNoofseatsavailable()));
													} else {
														log.info(
																"No Flights are available with this Flight Name");
													}
												}
												break;
											case 5:
												log.info("REMOVE FLIGHT ");
												log.info("ENTER FLIGHT ID");
												int flightId3 = scanner.nextInt();
												if (flightId3 == 0) {
													log.info("Please Enter the Valid FlightId");
												} else {
													FlightDetails bean6 = new FlightDetails();
													bean6.setFlightId(flightId3);
													boolean remove = service.removeFlight(flightId3);
													if (remove) {
														log.info("The Flight is removed of Id = " + flightId3);
													} else {
														log.info(
																"The Flight is not removed of Id = " + flightId3);
													}
												}
												break;
											case 6:
												List<FlightDetails> info = service.getFlightDetails();
												log.info(
														"<--------------------------------------------------------------------->");
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName", "Source", "Destination", "ArrivalDateTime",
														"DepartureDateTime", "NoofSeatAvailable"));
												for (FlightDetails flightBean : info) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
																flightBean.getFlightId(), flightBean.getFlightName(),
																flightBean.getSource(), flightBean.getDestination(),
																flightBean.getArrivalDateTime(),
																flightBean.getDepartureDateTime(),
																flightBean.getNoofseatsavailable()));
													} else {
														log.info(
																"No Flight are available in the Flight Details");
													}
												}
												break;
											case 9:
												airlineOperations();

											default:
												log.info(
														"Invalid Choice please provide 1 or 2 or 3 or 4 or 5 or 6  or 9");
												break;
											}
										} catch (InputMismatchException e) {
											log.error(
													"Invalid entry please provide 1 or 2 or 3 or 4 or 5 or 6  or 9");
											scanner.nextLine();
										} catch (Exception e) {
											log.info("Invalid Credentials");
										}
									} while (true);
								} catch (Exception e) {
									log.info("Invalid Credentials");
								}
								break;
							case 3:
								airlineOperations();
								break;

							default:
								log.info("Invalid Choice please provide 1 or 2 or 3");
								break;
							}
						} catch (InputMismatchException e) {
							log.error("Invalid entry please provide 1 or 2 or 3");
							scanner.nextLine();
						}

					} while (true);
				case 2:
					UserService service1 = new UserServiceImple();
					do {
						try {
							System.out
									.println("<--------------------------------------------------------------------->");
							log.info("[1] USER REGISTER");
							log.info("[2] USER LOGIN");
							log.info("[3] EXIT");
							System.out
									.println("<--------------------------------------------------------------------->");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:

								do {
									try {
										log.info("Enter ID to Register as USER : ");
										checkId = scanner.nextInt();
										validation.validatedId(checkId);
										flag = true;
									} catch (InputMismatchException e) {
										log.error("ID should consist of only digits");
										flag = false;
										scanner.next();
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Name to Register : ");
										checkName = scanner.next();
										validation.validatedName(checkName);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Name should consists of only Alphabates");
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter MobileNumber to Register : ");
										checkMobile = scanner.nextLong();
										validation.validatedMobile(checkMobile);
										flag = true;
									} catch (InputMismatchException e) {
										log.error("Mobile Number  should consists of only numbers");
										flag = false;
										scanner.next();
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Email to Register : ");
										checkEmail = scanner.next();
										// validation.validatedEmail(checkEmail);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error(
												"Enter proper email such that it should consist of numbers and alphabets");
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Password :");
										checkPassword = scanner.next();
										// validation.validatedPassword(checkPassword);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Password doesnt accept spaces ");
									} catch (ARSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								UserInfo bean1 = new UserInfo();
								bean1.setUserId(checkId);
								bean1.setUserName(checkName);
								bean1.setMobileNumber(checkMobileno);
								bean1.setEmailId(checkEmail);
								bean1.setPassword(checkPassword);

								boolean check = service1.registerUser(bean1);
								if (check) {
									log.info("Registered Successfully");
								} else {
									log.info("Already registered");
								}
								break;

							case 2:
								log.info("Enter registered email to login : ");
								String email = scanner.next();
								log.info("Enter registered Password to login : ");
								String password = scanner.next();
								try {
								
									UserInfo UserBean = service1.authenticateUser(email, password);
									log.info("Logged in Successfully");
									do {
										try {
											log.info(
													"<--------------------------------------------------------------------->");
											log.info("[1]  SEARCH FLIGHT BY SOURCE");
											log.info("[2]  SEARCH FLIGHT BY DESTINATION");
											log.info("[3] SEARCH FLIGHT BY NAME");
											log.info("[4]  VIEW ALL FLIGHTDETAILS");
											log.info("[5] SEARCH FLIGHT BY SOURCE AND DESTINATION");
											log.info("[6]  BOOK THE FLIGHT");
											log.info("[7]  LOGOUT");
											log.info(
													"<--------------------------------------------------------------------->");
											int choice2 = scanner.nextInt();
											switch (choice2) {
											case 1:
												log.info("Search Flight Details by Source : ");
												String source = scanner.next();

												FlightDetails bean3 = new FlightDetails();
												bean3.setSource(source);
												List<FlightDetails> flightSource1 = service1
														.searchFlightBySource(source);
												log.info(
														"<--------------------------------------------------------------------->");
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName", "Source", "Destination", "ArrivalDateTime",
														"DepartureDateTime", "NoofSeatAvailable"));
												for (FlightDetails flightBean : flightSource1) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
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
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName", "Source", "Destination", "ArrivalDateTime",
														"DepartureDateTime", "NoofSeatAvailable"));
												for (FlightDetails flightBean : flightDestination1) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
																flightBean.getFlightId(), flightBean.getFlightName(),
																flightBean.getSource(), flightBean.getDestination(),
																flightBean.getArrivalDateTime(),
																flightBean.getDepartureDateTime(),
																flightBean.getNoofseatsavailable()));
													} else {
														log.info(
																"No Flights are available with this Destination");
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
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName", "Source", "Destination", "ArrivalDateTime",
														"DepartureDateTime", "NoofSeatAvailable"));
												for (FlightDetails flightBean : fname) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
																flightBean.getFlightId(), flightBean.getFlightName(),
																flightBean.getSource(), flightBean.getDestination(),
																flightBean.getArrivalDateTime(),
																flightBean.getDepartureDateTime(),
																flightBean.getNoofseatsavailable()));
													} else {
														log.info(
																"No Flights are available with this Flight Name");
													}
												}
												break;
											case 4:
												List<FlightDetails> info = service1.getFlightDetails();
												log.info(
														"<--------------------------------------------------------------------->");
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName", "Source", "Destination", "ArrivalDateTime",
														"DepartureDateTime", "NoofSeatAvailable"));
												for (FlightDetails flightBean : info) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
																flightBean.getFlightId(), flightBean.getFlightName(),
																flightBean.getSource(), flightBean.getDestination(),
																flightBean.getArrivalDateTime(),
																flightBean.getDepartureDateTime(),
																flightBean.getNoofseatsavailable()));
													} else {
														log.info(
																"No Flight are available in the Flight Details");
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
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName", "Source", "Destination", "ArrivalDateTime",
														"DepartureDateTime", "NoofSeatAvailable"));
												for (FlightDetails flightBean : flightSourceToDestination) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
																flightBean.getFlightId(), flightBean.getFlightName(),
																flightBean.getSource(), flightBean.getDestination(),
																flightBean.getArrivalDateTime(),
																flightBean.getDepartureDateTime(),
																flightBean.getNoofseatsavailable()));
													} else {
														log.info(
																"No Flights are available with this Destination");
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
												log.info(String.format(
														"%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName", "Source", "Destination", "ArrivalDateTime",
														"DepartureDateTime", "NoofSeatAvailable"));
												for (FlightDetails flightBean : flightSourceToDestination1) {
													if (flightBean != null) {
														log.info(String.format(
																"%-10s %-10s %-13s %-15s %-20s %-20s %s",
																flightBean.getFlightId(), flightBean.getFlightName(),
																flightBean.getSource(), flightBean.getDestination(),
																flightBean.getArrivalDateTime(),
																flightBean.getDepartureDateTime(),
																flightBean.getNoofseatsavailable()));
													} else {
														log.info(
																"No Flights are available with this Destination");
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
														}
														catch (InputMismatchException e) {
															log.error("Invalid entry  ");
															scanner.nextLine();
														} catch (Exception e) {
															log.info("Invalid request");
														}
														break;
													case 2:
														airlineOperations();
													default:
														log.error("Invalid entry please provide 1 or 2 ");
														break;
													}
												} catch (InputMismatchException e) {
													log.error("Invalid entry please provide 1 or 2 ");
													scanner.nextLine();
												} catch (Exception e) {
													log.info("Invalid Credentials");
												}
												} while (true);

											case 7:
												airlineOperations();

											default:
												log.error(
														"Invalid entry please provide 1 or 2 or 3 or 4 or 5 or 7");
												break;
											}
										} catch (InputMismatchException e) {
											System.err
													.println("Invalid entry please provide 1 or 2 or 3 or 4 or 5 or 7");
											scanner.nextLine();
										} catch (Exception e) {
											log.error("Invalid Credentials");
										}
									} while (true);
								} catch (Exception e) {
									log.error("Invalid Credentials");
								}
								break;
							case 3:
								airlineOperations();
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

				default:
					log.info("Invalid Choice");
					log.error("Choice must be 1 or 2 ");
					break;
				}
			} catch (InputMismatchException e) { //// if we give string in 1 n 2
				log.error("Invalid entry please provide 1 or 2");
				scanner.nextLine();
			} catch (Exception e) {
				log.error("Invalid Credentials");
			}
		} while (true);
	}

}