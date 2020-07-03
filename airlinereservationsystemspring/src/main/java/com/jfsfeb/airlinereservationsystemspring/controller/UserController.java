package com.jfsfeb.airlinereservationsystemspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.airlinereservationsystemspring.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
}
