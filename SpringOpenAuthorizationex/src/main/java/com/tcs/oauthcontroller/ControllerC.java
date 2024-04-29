package com.tcs.oauthcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerC {
	@GetMapping("/")
	public String wish() {
		return "oauth.html";
	}

}
// create the html file into static folder if you want to create thymleaf which is dynamic create 
// in template folder if any file is dynamic create in template folder