package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	

	@ExceptionHandler(value = {NullPointerException.class}) 
	public String handleNPE() {
		return "error";
	}

}
