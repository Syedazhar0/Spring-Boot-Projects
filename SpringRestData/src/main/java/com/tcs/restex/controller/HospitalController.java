package com.tcs.restex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.restex.entity.Hospital;
import com.tcs.restex.repository.HospitalRepository;

@RequestMapping("/api")
@RestController
public class HospitalController {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	
	@PostMapping("/hello")
	public Hospital createHospital(@RequestBody Hospital hospital) {
		return  hospitalRepository.save(hospital);
	}

}
