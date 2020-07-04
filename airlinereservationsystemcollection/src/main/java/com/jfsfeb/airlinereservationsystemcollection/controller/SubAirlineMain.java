package com.jfsfeb.airlinereservationsystemcollection.controller;



import java.util.InputMismatchException;

import java.util.Scanner;


import lombok.extern.log4j.Log4j;
@Log4j
public class SubAirlineMain {
	public static void airlineOperations() {

		
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
					AdminController.adminOperations();
				case 2:
			         UserController.userOperations();

				default:
					log.info("Invalid Choice");
					log.error("Invalid entry please choose above option");
					break;
				}
			} catch (InputMismatchException e) { //// if we give string in 1 n 2
				log.error("Invalid entry please choose above option");
				scanner.nextLine();
			} catch (Exception e) {
				log.error("Invalid Credentials");
			}
		} while (true);
	}

}