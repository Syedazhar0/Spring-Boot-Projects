package com.tcs.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
	@GetMapping("/notice")
	public String getNoticeDetails() {
		return "these are your notices";
	}

}
