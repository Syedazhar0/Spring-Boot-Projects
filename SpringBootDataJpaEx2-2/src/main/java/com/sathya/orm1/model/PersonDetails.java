package com.sathya.orm1.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PersonDetails {
	private int pid;
	private String firstName;
	private String lastName;
	private String email;
	private String age;

}
