package com.tcs.mailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.mailservice.details.MailDetails;
import com.tcs.mailservice.service.SimpleMailService;

@RestController
public class SimpleMailSender {
	
	@Autowired
	SimpleMailService mailService;
	
	
	@PostMapping("/")
	public String sendMail(@RequestBody MailDetails mailDetails ) {
		return mailService.sendMail(mailDetails);
		
	}

}
