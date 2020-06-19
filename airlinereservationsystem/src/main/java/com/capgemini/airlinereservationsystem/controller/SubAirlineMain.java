package com.capgemini.airlinereservationsystem.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



import com.capgemini.airlinereservationsystem.dto.AdminInfo;
import com.capgemini.airlinereservationsystem.dto.BookingStatus;
import com.capgemini.airlinereservationsystem.dto.FlightDetails;
import com.capgemini.airlinereservationsystem.dto.UserInfo;
import com.capgemini.airlinereservationsystem.exception.ARSException;
import com.capgemini.airlinereservationsystem.repository.AirlineRepository;
import com.capgemini.airlinereservationsystem.service.AdminService;
import com.capgemini.airlinereservationsystem.service.AdminServiceImple;
import com.capgemini.airlinereservationsystem.service.UserService;
import com.capgemini.airlinereservationsystem.service.UserServiceImple;
import com.capgemini.airlinereservationsystem.validation.Validation;

public class SubAirlineMain {
	public static void airlineOperations() {

		AirlineRepository.addToDataBase();

		boolean flag = false;
		int checkId = 0;
		String checkName = null;
		long checkMobile = 0;
		String checkMobileno=null;
		String checkEmail = null;
		String checkPassword = null;
		int flightId = 0;
		String flightName = null;
		String flightSource = null;
		String flightDestination = null;
	    int noofSeatsAvailable = 0;
	    LocalDateTime arrivalDateTime=null;
	    LocalDateTime departureDateTime=null;
		Validation validation = new Validation();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				System.out.println("<----------------------<<< WELCOME TO AIRLINE RESERVATION SYSTEM >>>--------------------->");
				System.out.println("[1] ADMIN PAGE");
				System.out.println("[2] USER PAGE");
				System.out.println("<--------------------------------------------------------------------->");
				int i = scanner.nextInt();
				switch (i) {
				case 1:
					AdminService service = new AdminServiceImple(); 
					do {
						try {
							System.out
									.println("<--------------------------------------------------------------------->");
							System.out.println("[1] ADMINISTRATION REGISTER");
							System.out.println("[2] ADMINISTRATION LOGIN");
							System.out.println("[3] EXIT");
							System.out
									.println("<--------------------------------------------------------------------->");
							int choice = scanner.nextInt();
							switch (choice) {
							
						
						case 1:
							do {
								try {
									System.out.println("Enter ID to Register as ADMIN : ");
									checkId = scanner.nextInt();
									validation.validatedId(checkId);
									flag = true;
								} catch (InputMismatchException e) {
									System.err.println("ID should consist of only digits");
									flag = false;
									scanner.next();
								} catch (ARSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
							do {
								try {
									System.out.println("Enter Name to Register : ");
									checkName = scanner.next();
									validation.validatedName(checkName);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Name should consists of only Alphabates");
								} catch (ARSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
							do {
								try {
									System.out.println("Enter MobileNumber to Register : ");
									checkMobile = scanner.nextLong();
									validation.validatedMobile(checkMobile);
									flag = true;
								} catch (InputMismatchException e) {
									System.err.println("Mobile Number  should consists of only numbers");
									flag = false;
									scanner.next();
								} catch (ARSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
							do {
								try {
									System.out.println("Enter Email to Register : ");
									checkEmail = scanner.next();
									validation.validatedEmail(checkEmail);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println(
											"Enter proper email such that it should consist of numbers and alphabets");
								} catch (ARSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
							do {
								try {
									System.out.println("Enter Password :");
									checkPassword = scanner.next();
									validation.validatedPassword(checkPassword);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Password doesnt accept spaces ");
								} catch (ARSException e) {
									flag = false;
									System.err.println(e.getMessage());
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
								System.out.println("You have registered Successfully");
							} else {
								System.out.println("Already registered");
							}
							break;
							
						case 2:
							System.out.println("Enter registered email to login : ");
							String email = scanner.next();
							System.out.println("Enter registered Password to login : ");
							String password = scanner.next();
							try {
								@SuppressWarnings("unused")
								AdminInfo authBean = service.authenticateAdmin(email, password);
								System.out.println("You have logged in successfully");
								System.out.println("Now you can perform the following operations:-");
								do {
									try {
										System.out.println(
												"<--------------------------------------------------------------------->");
										System.out.println("[1]  ADD FLIGHTS");
										System.out.println("[2]  SEARCH FLIGHT BY SOURCE");
										System.out.println("[3]  SEARCH FLIGHT BY DESTINATION");
										System.out.println("[4]  SEARCH FLIGHT BY NAME");
										System.out.println("[5]  REMOVE FLIGHT");
										System.out.println("[6]  VIEW ALL FLIGHTDETAILS");
										//System.out.println("[7]  ISSUE FLIGHTDETAILS");
										//System.out.println("[8]  VIEW ALL USER");
										
										System.out.println("[9] LOGOUT");
										System.out.println(
												"<--------------------------------------------------------------------->");
										int choice1 = scanner.nextInt();
										switch (choice1) {
										case 1:

											do {
												System.out.println("Enter FlightID to add : ");
												flightId = scanner.nextInt();
												try {
													validation.validatedId(flightId);
													flag = true;
												} catch (InputMismatchException e) {
													flag = false;
													System.err.println("Id should contains only digits");
												} catch (ARSException e) {
													flag = false;
													System.err.println(e.getMessage());
												}
											} while (!flag);
											do {
												System.out.println("Enter FlightName : ");
												flightName= scanner.next();
												try {
													validation.validatedName(flightName);
													flag = true;
												} catch (InputMismatchException e) {
													flag = false;
													System.err.println("FlightName should contains only Alphabets");
												} catch (ARSException e) {
													flag = false;
													System.err.println(e.getMessage());
												}
											} while (!flag);
											do {
												System.out.println("Enter Source : ");
												 flightSource = scanner.next();
												try {
													validation.validatedName(flightSource);
													flag = true;
												} catch (InputMismatchException e) {
													flag = false;
													System.err
															.println("Source should contains only Alphabates");
												} catch (ARSException e) {
													flag = false;
													System.err.println(e.getMessage());
												}
											} while (!flag);
											do {
												System.out.println("Enter Destination : ");
												flightDestination = scanner.next();
												try {
													validation.validatedName(flightDestination);
													flag = true;
												} catch (InputMismatchException e) {
													flag = false;
													System.err.println(
															"Destination should contains only Alphabates");
												} catch (ARSException e) {
													flag = false;
													System.err.println(e.getMessage());
												}
											} while (!flag);
											do {
												System.out.println("Enter No.of seat Available in the Flight : ");
												noofSeatsAvailable = scanner.nextInt();
												try {
													//validation.validatedId(noofSeatsAvailable);
													flag = true;
												} catch (InputMismatchException e) {
													flag = false;
													System.err.println("noofSeatsAvailable should contains only digits");
												} catch (ARSException e) {
													flag = false;
													System.err.println(e.getMessage());
												}
											} while (!flag);
											do {
												System.out.println("Enter  Flight Arrival Date Time : ");
												 arrivalDateTime=LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
												try {
													//validation.validatedId(noofSeatsAvailable);
													flag = true;
												} catch (InputMismatchException e) {
													flag = false;
													System.err.println("its should contains only digits");
												} catch (ARSException e) {
													flag = false;
													System.err.println(e.getMessage());
												}
											} while (!flag);
											do {
												System.out.println("Enter  Flight departure Date Time : ");
												 departureDateTime=LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
												try {
													//validation.validatedId(noofSeatsAvailable);
													flag = true;
												} catch (InputMismatchException e) {
													flag = false;
													System.err.println("its should contains only digits");
												} catch (ARSException e) {
													flag = false;
													System.err.println(e.getMessage());
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
												System.out.println("Flight added of id = " + flightId);
											} else {
												System.out.println("Flight already exist of id = " + flightId);
											}
											break;
										case 2:
											System.out.println("Search Flight Details by Source : ");
											String source = scanner.next();

											FlightDetails bean3 = new FlightDetails();
											bean3.setSource(source);
											ArrayList<FlightDetails> flightSource1 = service.searchFlightBySource(source);
											System.out.println(
													"<--------------------------------------------------------------------->");
											System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
													"FlightName", "Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));
											for (FlightDetails flightBean : flightSource1) {
												if (flightBean != null) {
													System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", flightBean.getFlightId(),
															flightBean.getFlightName(),flightBean.getSource(), flightBean.getDestination(),flightBean.getArrivalDateTime(),flightBean.getDepartureDateTime(),flightBean.getNoofseatsavailable()));
												} else {
													System.out
															.println("No Flights are available with this Source");
												}
											}
											break;
										case 3:
											System.out.println("Search flight by Destination : ");
											String destination= scanner.next();

											FlightDetails bean4 = new FlightDetails();
											bean4.setDestination(destination);
											ArrayList<FlightDetails> flightDestination1 = service.searchFlightByDestination(destination);
											System.out.println(
													"<<--------------------------------------------------------------------->>");
											System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
													"FlightName", "Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));
											for (FlightDetails flightBean : flightDestination1) {
												if (flightBean != null) {
													System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", flightBean.getFlightId(),
															flightBean.getFlightName(),flightBean.getSource(), flightBean.getDestination(),flightBean.getArrivalDateTime(),flightBean.getDepartureDateTime(),flightBean.getNoofseatsavailable()));
												} else {
													System.out.println("No Flights are available with this Destination");
												}
											}
											break;
										case 4:
											System.out.println(" SEARCH FLIGHT BY NAME : ");
											String name = scanner.next();

											FlightDetails bean5 = new FlightDetails();
											bean5.setFlightName(name);;
											ArrayList<FlightDetails> fname = service.searchFlightByName(name);
											System.out.println(
													"<--------------------------------------------------------------------->");
											System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
													"FlightName", "Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));
											for (FlightDetails flightBean : fname) {
												if (flightBean != null) {
													System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", flightBean.getFlightId(),
															flightBean.getFlightName(),flightBean.getSource(), flightBean.getDestination(),flightBean.getArrivalDateTime(),flightBean.getDepartureDateTime(),flightBean.getNoofseatsavailable()));
												} else {
													System.out.println("No Flights are available with this Flight Name");
												}
											}
											break;
										case 5:
											System.out.println("REMOVE FLIGHT ");
											System.out.println("ENTER FLIGHT ID");
											int flightId3 = scanner.nextInt();
											if (flightId3 == 0) {
												System.out.println("Please Enter the Valid FlightId");
											} else {
												FlightDetails bean6 = new FlightDetails();
												bean6.setFlightId(flightId3);
												boolean remove = service.removeFlight(flightId3);
												if (remove) {
													System.out.println("The Flight is removed of Id = " + flightId3);
												} else {
													System.out
															.println("The Flight is not removed of Id = " + flightId3);
												}
											}
											break;
										case 6:
											ArrayList<FlightDetails> info = service.getFlightDetails();
											System.out.println(
													"<--------------------------------------------------------------------->");
											System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
													"FlightName", "Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));
											for (FlightDetails flightBean : info) {
												if (flightBean != null) {
													System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", flightBean.getFlightId(),
															flightBean.getFlightName(),flightBean.getSource(), flightBean.getDestination(),flightBean.getArrivalDateTime(),flightBean.getDepartureDateTime(),flightBean.getNoofseatsavailable()));
												} else {
													System.out.println("No Flight are available in the Flight Details");
												}
											}
											break;
										case 9:
											airlineOperations();

										default:
											System.out.println("Invalid Choice");
											break;
										}
									} catch (InputMismatchException e) {
										System.err.println("Invalid entry please provide only positive integer");
										scanner.nextLine();
									}
								} while (true);
							} catch (Exception e) {
								System.out.println("Invalid Credentials");
							}
							break;
						case 3:
							airlineOperations();
							break;

						default:
							System.out.println("Invalid Choice");
							break;
						}
					} catch (InputMismatchException e) {
						System.err.println("Invalid entry please provide only positive integer");
						scanner.nextLine();
					}
				} while (true);
				case 2:
					UserService service1 = new UserServiceImple();
					do {
						try {
							System.out
									.println("<--------------------------------------------------------------------->");
							System.out.println("[1] USER REGISTER");
							System.out.println("[2] USER LOGIN");
							System.out.println("[3] EXIT");
							System.out
									.println("<--------------------------------------------------------------------->");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:
							
								do {
									try {
										System.out.println("Enter ID to Register as USER : ");
										checkId = scanner.nextInt();
										validation.validatedId(checkId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID should consist of only digits");
										flag = false;
										scanner.next();
									} catch (ARSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										System.out.println("Enter Name to Register : ");
										checkName = scanner.next();
										validation.validatedName(checkName);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Name should consists of only Alphabates");
									} catch (ARSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										System.out.println("Enter MobileNumber to Register : ");
										checkMobile = scanner.nextLong();
										validation.validatedMobile(checkMobile);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("Mobile Number  should consists of only numbers");
										flag = false;
										scanner.next();
									} catch (ARSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										System.out.println("Enter Email to Register : ");
										checkEmail = scanner.next();
										//validation.validatedEmail(checkEmail);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println(
												"Enter proper email such that it should consist of numbers and alphabets");
									} catch (ARSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										System.out.println("Enter Password :");
										checkPassword = scanner.next();
										//validation.validatedPassword(checkPassword);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Password doesnt accept spaces ");
									} catch (ARSException e) {
										flag = false;
										System.err.println(e.getMessage());
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
									System.out.println("Registered Successfully");
								} else {
									System.out.println("Already registered");
								}
								break;
								
						       case 2:
							System.out.println("Enter registered email to login : ");
							String email = scanner.next();
							System.out.println("Enter registered Password to login : ");
							String password = scanner.next();
							try {
								@SuppressWarnings("unused")
								UserInfo UserBean = service1.authenticateUser(email, password);
								System.out.println("Logged in Successfully");
								do {
									try {
										System.out.println(
												"<--------------------------------------------------------------------->");
										System.out.println("[1]  SEARCH FLIGHT BY SOURCE");
										System.out.println("[2]  SEARCH FLIGHT BY DESTINATION");
										System.out.println("[3] SEARCH FLIGHT BY NAME");
										System.out.println("[4]  VIEW ALL FLIGHTDETAILS");
										System.out.println("[5] BOOK THE FLIGHT");
										//System.out.println("[6]  RETURN BOOK");
										System.out.println("[7]  LOGOUT");
										System.out.println(
												"<--------------------------------------------------------------------->");
										int choice2 = scanner.nextInt();
										switch (choice2) {
										case 1:
											System.out.println("Search Flight Details by Source : ");
											String source = scanner.next();

											FlightDetails bean3 = new FlightDetails();
											bean3.setSource(source);
											ArrayList<FlightDetails> flightSource1 = service1.searchFlightBySource(source);
											System.out.println(
													"<--------------------------------------------------------------------->");
											System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
													"FlightName", "Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));
											for (FlightDetails flightBean : flightSource1) {
												if (flightBean != null) {
													System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", flightBean.getFlightId(),
															flightBean.getFlightName(),flightBean.getSource(), flightBean.getDestination(),flightBean.getArrivalDateTime(),flightBean.getDepartureDateTime(),flightBean.getNoofseatsavailable()));
												} else {
													System.out
															.println("No Flights are available with this Source");
												}
											}
											break;

										case 2:

											System.out.println("Search flight by Destination : ");
											String destination= scanner.next();

											FlightDetails bean4 = new FlightDetails();
											bean4.setDestination(destination);
											ArrayList<FlightDetails> flightDestination1 = service1.searchFlightByDestination(destination);
											System.out.println(
													"<<--------------------------------------------------------------------->>");
											System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
													"FlightName", "Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));
											for (FlightDetails flightBean : flightDestination1) {
												if (flightBean != null) {
													System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", flightBean.getFlightId(),
															flightBean.getFlightName(),flightBean.getSource(), flightBean.getDestination(),flightBean.getArrivalDateTime(),flightBean.getDepartureDateTime(),flightBean.getNoofseatsavailable()));
												} else {
													System.out.println("No Flights are available with this Destination");
												}
											}
											break;
										case 3:
											System.out.println(" SEARCH FLIGHT BY NAME : ");
											String name = scanner.next();

											FlightDetails bean5 = new FlightDetails();
											bean5.setFlightName(name);;
											ArrayList<FlightDetails> fname = service1.searchFlightByName(name);
											System.out.println(
													"<--------------------------------------------------------------------->");
											System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
													"FlightName", "Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));
											for (FlightDetails flightBean : fname) {
												if (flightBean != null) {
													System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", flightBean.getFlightId(),
															flightBean.getFlightName(),flightBean.getSource(), flightBean.getDestination(),flightBean.getArrivalDateTime(),flightBean.getDepartureDateTime(),flightBean.getNoofseatsavailable()));
												} else {
													System.out.println("No Flights are available with this Flight Name");
												}
											}
											break;
										case 4:
											ArrayList<FlightDetails> info = service1.getFlightDetails();
											System.out.println(
													"<--------------------------------------------------------------------->");
											System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
													"FlightName", "Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));
											for (FlightDetails flightBean : info) {
												if (flightBean != null) {
													System.out.println(String.format("%-10s %-10s %-13s %-15s %-20s %-20s %s", flightBean.getFlightId(),
															flightBean.getFlightName(),flightBean.getSource(), flightBean.getDestination(),flightBean.getArrivalDateTime(),flightBean.getDepartureDateTime(),flightBean.getNoofseatsavailable()));
												} else {
													System.out.println("No Flight are available in the Flight Details");
												}
											}
											break;
										case 5:
											System.out.println("Enter User Id : ");
											int userId2 = scanner.nextInt();
                                             
										     UserInfo userBean = new UserInfo();
											userBean.setUserId(userId2);
											System.out.println("Enter Flight Id : ");
											int flightId2 = scanner.nextInt();
                                             FlightDetails flightDetails1 = new FlightDetails();                                    
                                             flightDetails1.setFlightId(flightId2);
                                             System.out.println("Enter No of seats : ");
                                             int seats=scanner.nextInt();
                                             BookingStatus bookingStatus=new BookingStatus();
                                             bookingStatus.setNoofSeatsBooked(seats);
                                             
                                             
											try {
												BookingStatus request = service1.bookRequest(userBean, flightDetails1);
												System.out.println("Request placed to Airline Management ");
												System.out.println(
														"<--------------------------------------------------------------------->");
												System.out.println(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s", "FlightId",
														"FlightName","User ID","UserName","Source", "Destination","ArrivalDateTime","DepartureDateTime", "NoofSeatAvailable"));;
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-13s %-15s %-20s %-20s %s",
														request.getFlightDetails().getFlightId(),
														request.getFlightDetails().getFlightName(),
														request.getUserInfo().getUserId(),
														request.getUserInfo().getUserName(),
														request.getFlightDetails().getSource(),
														request.getFlightDetails().getDestination(),
														request.getFlightDetails().getArrivalDateTime(),
														request.getFlightDetails().getDepartureDateTime(),
														bookingStatus.getNoofSeatsBooked()
														));
											} catch (Exception e) {
												System.out.println("Invalid Request of booking");
											}
											break;
										case 7:
											airlineOperations();

										default:
											break;
										}
									} catch (InputMismatchException e) {
										System.err.println("Invalid entry please provide only positive integer");
										scanner.nextLine();
									}
								} while (true);
							} catch (Exception e) {
								System.err.println("Invalid Credentials");
							}
							break;
						case 3:
							airlineOperations();
							break;

						default:
							System.out.println("Invalid Choice");
							System.err.println("Choice must be 1 or 2");
							break;
						}
					} catch (InputMismatchException e) { // if we give string in 1 n 2 n 3
						System.err.println("Invalid entry please provide only positive integer");
						scanner.nextLine();
					}
				} while (true);
			}
		} catch (InputMismatchException e) { //// if we give string in 1 n 2
			System.err.println("Invalid entry please provide only positive integer");
			scanner.nextLine();
		}
	} while (true);
}


}