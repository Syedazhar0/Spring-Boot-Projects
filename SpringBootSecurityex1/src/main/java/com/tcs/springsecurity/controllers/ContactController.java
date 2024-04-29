package com.tcs.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
@GetMapping("/mycontactdetails")
public String getContactDetails() {
	return "these are your contact details";
}
}
