package com.tcs.microservices2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetails {
	private String firstName;
	private String lastName;
	private String email;
}
