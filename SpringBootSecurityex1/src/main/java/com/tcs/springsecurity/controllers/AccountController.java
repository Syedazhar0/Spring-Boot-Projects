package com.tcs.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	@GetMapping("/myaccount")
	public String info() {
		return "this is your account details";
	}
// localhost:8967/myaccount by default username user password start the appli there in console 
	// password 2d994a04-fd6c-4976-a2f2-aff797dd0062 but you can change pass and user
	// in application property write commands to change the username and pass
}
