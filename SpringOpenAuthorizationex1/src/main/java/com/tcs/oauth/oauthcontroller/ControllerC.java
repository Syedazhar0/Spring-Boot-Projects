package com.tcs.oauth.oauthcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerC {
	@GetMapping("/")
	public String wish() {
		return "oauth.html";
	}

}

