package com.jfsfeb.airlinereservationsystemspring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jfsfeb.airlinereservationsystemspring.bean.ARSResponseBean;
import com.jfsfeb.airlinereservationsystemspring.bean.User;

public class AirlineController {
    @PostMapping(path="/login",
    		consumes = MediaType.APPLICATION_JSON_VALUE)
    
	public ARSResponseBean login(@RequestBody User user) {
		
    	return null;
	}
}
