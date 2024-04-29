package com.tcs.microservices2.studentresponse;

import com.tcs.microservices2.addressresponse.AddressResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class StudentResponse {
	private long id;
	private String firstName;
	private String lastName;
	private String email;

	private AddressResponse addressResponse;
	
}
