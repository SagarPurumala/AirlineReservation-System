package com.jfsfeb.airlinereservationsystemhibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemhibernate.dto.User;
import com.jfsfeb.airlinereservationsystemhibernate.exception.ARSException;
import com.jfsfeb.airlinereservationsystemhibernate.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemhibernate.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserController {
public static void userOperations() {
		
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	UserService service1 = AirlineFactory.getUserServiceImplInstance();

	do {
		try {
			log.info("You have logged in successfully as a User");
			log.info("Now you can perform the following operations:-");
			log.info("<--------------------------------------------------------------------->");

			log.info("[1]  VIEW ALL FLIGHTDETAILS");
			log.info("[2]  SEARCH FLIGHT BY SOURCE");
			log.info("[3]  SEARCH FLIGHT BY DESTINATION");
			log.info("[4] SEARCH FLIGHT BY NAME");
			log.info("[5] SEARCH FLIGHT BY SOURCE AND DESTINATION");
			log.info("[6]  BOOK THE FLIGHT");
			log.info("[7]  CANCEL THE FLIGHT BASED ON TICKET ID");
			log.info("[8]  TICKET DETAILS BASED ON USER ID");
			log.info("[9]  LOGOUT");
			log.info("<--------------------------------------------------------------------->");
			int choice2 = scanner.nextInt();
			switch (choice2) {
			case 1:
				List<FlightDetails> info = service1.getFlightDetails();
				log.info("<--------------------------------------------------------------------->");
				log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s", "FlightId",
						"FlightName", "Source", "Destination", "ArrivalDate", "ArrivalTime", "DepartureDate",
						"DepartureTime", "NoofSeatAvailable"));
				for (FlightDetails flightBean : info) {
					if (flightBean != null) {
						log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s",
								flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
								flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
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
				log.info("Search Flight Details by Source : ");
				String source = scanner.next();

				FlightDetails bean3 = new FlightDetails();
				bean3.setSource(source);
				List<FlightDetails> flightSource1 = service1.searchFlightBySource(source);
				log.info("<--------------------------------------------------------------------->");
				log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s", "FlightId",
						"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "Departure Date",
						"Departure Time", "NoofSeatAvailable"));
				for (FlightDetails flightBean : flightSource1) {
					if (flightBean != null) {
						log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s",
								flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
								flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
								java.sql.Time.valueOf(flightBean.getArrivalTime()),
								java.sql.Date.valueOf(flightBean.getDepartureDate()),
								java.sql.Time.valueOf(flightBean.getDepartureTime()),
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
				List<FlightDetails> flightDestination1 = service1.searchFlightByDestination(destination);
				log.info("<<--------------------------------------------------------------------->>");
				log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s", "FlightId",
						"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "Departure Date",
						"Departure Time", "NoofSeatAvailable"));
				for (FlightDetails flightBean : flightDestination1) {
					if (flightBean != null) {
						log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s",
								flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
								flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
								java.sql.Time.valueOf(flightBean.getArrivalTime()),
								java.sql.Date.valueOf(flightBean.getDepartureDate()),
								java.sql.Time.valueOf(flightBean.getDepartureTime()),
								flightBean.getNoofseatsavailable()));
					} else {
						log.info("No Flights are available with this Destination");
					}
				}
				break;
			case 4:
				log.info(" SEARCH FLIGHT BY NAME : ");
				String name = scanner.next();

				FlightDetails bean5 = new FlightDetails();
				bean5.setFlightName(name);
				;
				List<FlightDetails> fname = service1.searchFlightByName(name);
				log.info("<--------------------------------------------------------------------->");
				log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s", "FlightId",
						"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "Departure Date",
						"Departure Time", "NoofSeatAvailable"));
				for (FlightDetails flightBean : fname) {
					if (flightBean != null) {
						log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s",
								flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
								flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
								java.sql.Time.valueOf(flightBean.getArrivalTime()),
								java.sql.Date.valueOf(flightBean.getDepartureDate()),
								java.sql.Time.valueOf(flightBean.getDepartureTime()),
								flightBean.getNoofseatsavailable()));
					} else {
						log.info("No Flights are available with this Flight Name");
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
				List<FlightDetails> flightSourceToDestination = service1.searchFlightBySourceAndDestination(source1,
						destination1);
				log.info("<<--------------------------------------------------------------------->>");
				log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s", "FlightId",
						"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "Departure Date",
						"Departure Time", "NoofSeatAvailable"));
				for (FlightDetails flightBean : flightSourceToDestination) {
					if (flightBean != null) {
						log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s",
								flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
								flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
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
				log.info("<<--------------------------------------------------------------------->>");
				log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s", "FlightId",
						"Flight Name", "Source", "Destination", "Arrival Date", "Arrival Time", "Departure Date",
						"Departure Time", "NoofSeatAvailable"));
				for (FlightDetails flightBean : flightSourceToDestination1) {
					if (flightBean != null) {
						log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s",
								flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
								flightBean.getDestination(), java.sql.Date.valueOf(flightBean.getArrivalDate()),
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
						log.info("<--------------------------------------------------------------------->");
						log.info("[1]  PROCEED TO BOOK");
						log.info("[2]  GO BACK");
						log.info("[3]  LOGOUT");

						log.info("<--------------------------------------------------------------------->");
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
								int bookingId = (int) (Math.random() * 10000);
								if (bookingId <= 1000) {
									bookingId = bookingId + 1000;
								}

								BookingStatus bookingStatus = new BookingStatus();
								bookingStatus.setNoofseatsbooked(seats);
								
								bookingStatus.setTicketId(bookingId);
								bookingStatus.setId(userId2);
								bookingStatus.setFlightId(flightId2);
								try {
									BookingStatus request = service1.bookRequest(bookingStatus);
									log.info("Request placed to Airline Management ");
									log.info(
											"<--------------------------------------------------------------------->");
									log.info(String.format("%-10s %-10s %-10s %s", "TicketId", "FlightId", "UserID",
											"NoofSeatBooked"));
									;
									log.info(String.format("%-10s %-10s %-10s %s", request.getTicketId(),
											request.getFlightId(), request.getId(), request.getNoofseatsbooked()));
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
							UserController.userOperations();
						case 3:
							SubAirlineController.airlineOperations();
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
				log.info("CANCEL TICKET  ");
				log.info("ENTER TICKET ID");
				try {
					int ticketId = scanner.nextInt();
					if (ticketId == 0) {
						log.info("Please Enter the Valid FlightId");
					} else {
						BookingStatus book = new BookingStatus();
						book.setTicketId(ticketId);
						boolean remove = service1.cancelTicket(ticketId);
						if (remove) {
							log.info("The Cancel ticket Id = " + ticketId);
						} else {
							log.info("The Ticked Id is not removed = " + ticketId);
						}
					}
				} catch (InputMismatchException e) {
					log.error("Invalid entry valid Id");
					scanner.nextLine();
				} catch (ARSException e) {
					log.info(e.getMessage());
				}
				break;
			case 8:
				log.info("ENTER USER ID TO FIND TICKET DETAILS");
				try {
					int userId = scanner.nextInt();
					List<BookingStatus> ticket = service1.getTicketDetails(userId);

					log.info("<--------------------------------------------------------------------->");
					log.info(String.format("%-10s %-10s %-10s %s", "TicketID", "FlightId", "UserID",
							"NoofSeatBooked"));
					for (BookingStatus request : ticket) {
						if (request != null) {
							log.info(String.format("%-10s %-10s %-10s %s", request.getTicketId(),
									request.getFlightId(), request.getId(), request.getNoofseatsbooked()));
						} else {
							log.info("Request not found in booking status");
						}
					}
				} catch (InputMismatchException e) {
					log.error("Invalid entry valid Id");
					scanner.nextLine();
				} catch (ARSException e) {
					log.info(e.getMessage());
				}
				break;
			case 9:
				SubAirlineController.airlineOperations();

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
}
