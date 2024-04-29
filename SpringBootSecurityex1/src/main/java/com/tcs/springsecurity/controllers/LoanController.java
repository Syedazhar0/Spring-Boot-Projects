package com.tcs.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
@GetMapping("/myloandetails")
public String getLoanDetails() {
	return "these are your loan details";
}
}
