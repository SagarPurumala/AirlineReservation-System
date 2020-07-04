package com.jfsfeb.airlinereservationsystemspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jfsfeb.airlinereservationsystemspring.bean.ARSResponseBean;
import com.jfsfeb.airlinereservationsystemspring.exception.ARSException;

@RestControllerAdvice
public class AirlineControllerAdvice {
   @ExceptionHandler(ARSException.class)
   public ARSResponseBean handleARSException(ARSException arsException) {
	   ARSResponseBean arsResponseBean=new ARSResponseBean();
	   arsResponseBean.setMessage(arsException.getMessage());
	   
       return arsResponseBean;
   }
   @ExceptionHandler(Exception.class)
   public ARSResponseBean handleExecption(Exception e) {
	   ARSResponseBean arsResponseBean=new ARSResponseBean();
	   arsResponseBean.setMessage(e.getMessage());
	   
       return arsResponseBean;
   }

}
