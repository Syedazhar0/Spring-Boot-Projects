package com.tcs.restex.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HospitalDetails {
	@NotNull(message = "name is madetory")
	private String name;
	@NotNull(message = "location is madetory")
	private String location;
	private double rating;
	@Email(message = "invalid email")
	@NotNull(message = "email is madetory")
    private String email;
	
	@Pattern(regexp = "[0-9]{10}", message = "invalid mobile number")
	@NotNull(message = "mobile is madetory")
	private String mobile;

}
