package com.sathya.orm1.entity;

import java.time.LocalDateTime;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)// used to auto generate ids
 private int pid;
	private String firstName;
	private String lastName;
	private String email;
	private String age;
	
	
	@CreatedDate
	private LocalDateTime createAt;
	@CreatedBy
	private String createBy;
	

}
