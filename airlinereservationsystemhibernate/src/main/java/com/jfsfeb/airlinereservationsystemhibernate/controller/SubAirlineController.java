package com.jfsfeb.airlinereservationsystemhibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemhibernate.dto.User;
import com.jfsfeb.airlinereservationsystemhibernate.exception.ARSException;
import com.jfsfeb.airlinereservationsystemhibernate.factory.AirlineFactory;
import com.jfsfeb.airlinereservationsystemhibernate.service.AirlineService;

import lombok.extern.log4j.Log4j;

@Log4j
public class SubAirlineController {
	public static void airlineOperations() {

		String checkName = null;
		long checkMobile = 0;
		String checkEmail = null;
		String checkPassword = null;
		String role = null;
		String email = null;
		String password = null;

		AirlineService service = AirlineFactory.getAirlineServiceImplInstance();
		log.info("<----------------------<<< WELCOME TO AIRLINE RESERVATION SYSTEM >>>--------------------->");
		List<FlightDetails> info = service.getFlightDetails();
		log.info("<--------------------------------------------------------------------->");
		log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s", "FlightId", "FlightName", "Source",
				"Destination", "ArrivalDate", "ArrivalTime", "DepartureDate", "DepartureTime", "NoofSeatAvailable"));
		for (FlightDetails flightBean : info) {
			if (flightBean != null) {
				log.info(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-20s %-20s %s", flightBean.getFlightId(),
						flightBean.getFlightName(), flightBean.getSource(), flightBean.getDestination(),
						java.sql.Date.valueOf(flightBean.getArrivalDate()),
						java.sql.Time.valueOf(flightBean.getArrivalTime()),
						java.sql.Date.valueOf(flightBean.getDepartureDate()),
						java.sql.Time.valueOf(flightBean.getDepartureTime()), flightBean.getNoofseatsavailable()));
			} else {
				log.info("No Flight are available in the Flight Details");
			}
		}
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {

				log.info("[1] SEARCH FLIGHT BY SOURCE AND DESTINATION");
				log.info("[2] LOGIN");
				log.info("[3] REGISTER(NEW USER)");
				log.info("<--------------------------------------------------------------------->");
				int i = scanner.nextInt();

				switch (i) {

				case 1:
					log.info("Search flight by Source : ");
					String source1 = scanner.next();
					log.info("Search flight by Destination : ");
					String destination1 = scanner.next();
					FlightDetails bean6 = new FlightDetails();
					bean6.setDestination(source1);
					bean6.setDestination(destination1);
					List<FlightDetails> flightSourceToDestination = service.searchFlightBySourceAndDestination(source1,
							destination1);
					if(flightSourceToDestination!=null) {
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
							log.info("No Flights are available with this Source and Destination");
						}
					}}else {
						log.info("No Flights are available with this Source and Destination");
					}
					break;
				case 2:
					log.info("Enter registered email to login : ");
					email = scanner.next();
					log.info("Enter registered Password to login : ");
					password = scanner.next();

					try {
						User authBean = service.authenticate(email, password);
						if (authBean != null) {
							String roleAdmin = "admin";
							String roleUser = "user";
							if (authBean.getRole().equals(roleAdmin)) {
								AdminController.adminOperations();
							} else if (authBean.getRole().equals(roleUser)) {
								UserController.userOperations();
							}
						} else {
							log.info("emailid and password should not be null ");
						}
					} catch (ARSException e) {
						log.info(e.getMessage());
					}
					break;
				case 3:
					try {

						log.info("Enter Name to Register : ");
						checkName = scanner.next();
						log.info("Enter MobileNumber to Register : ");
						checkMobile = scanner.nextLong();
						log.info("Enter Email to Register : ");
						checkEmail = scanner.next();
						log.info("Enter Password :");
						checkPassword = scanner.next();
						role = "user";
						int userId = (int) (Math.random() * 10000);
						if (userId <= 1000) {
							userId = userId + 1000;
						}
						User bean = new User();
						bean.setId(userId);
						bean.setName(checkName);
						bean.setMobileNumber(checkMobile);
						bean.setEmailId(checkEmail);
						bean.setPassword(checkPassword);
						bean.setRole(role);

						boolean check = service.register(bean);
						if (check) {
							log.info("You have registered Successfully");
							log.info("Your registered UserId :" + userId);
						} else {
							log.info("Already registered");
						}
						break;
					} catch (InputMismatchException e) {
						log.error("Invalid entry ");
						scanner.next();
						break;
					} catch (ARSException e) {
						log.info(e.getMessage());
						break;
					}

				default:
					log.info("Invalid Choice");
					log.error("Invalid entry please choose from above options");
					break;
				}
			} catch (InputMismatchException e) { //// if we give string in 1 n 2 n 3 n 4
				log.error("Invalid entry please choose from above options");
				scanner.nextLine();
			} catch (ARSException e) {
				log.info(e.getMessage());

			} catch (Exception e) {
				log.error("Invalid Credentials");
			}

		} while (true);
	}

}
