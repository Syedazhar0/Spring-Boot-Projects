package com.tcs.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
	@GetMapping("/mybalance")
	public String getBalance() {
		return "this is your balance details";
	}

}