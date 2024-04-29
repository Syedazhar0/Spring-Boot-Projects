package com.tcs.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
	@GetMapping("/mycard")
	public String getCardDetails() {
		return "this is your card details......";
	}

}
