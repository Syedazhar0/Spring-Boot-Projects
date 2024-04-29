package com.sathya.RestApi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


// this annotation indicates that this class is restapi class in this we are
// creating the restCalls of RestApis these are used to communicate with two differenent applications
// like one is java based application another is php or .net or python
@RestController 
public class FirstRestApiEx1 {
	
	// create method by applying @GetMapping get is used to get the data and path mean url inside
	// @GetMapping("path")
	@GetMapping("/test")
	public String greet() {
		return "hello world";
	}
	

}











