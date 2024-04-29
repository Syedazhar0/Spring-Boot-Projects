package com.sathya.orm.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity// is used to create the table in database
@Data // it contains all annotations like getter setter tostring hashcode&equals empty constructor
@AllArgsConstructor // used to create constructor with arguments
@NoArgsConstructor // used to create no argument constructor 
public class Product {
	@Id// primary key
	private int proId;
	private String proName;
	private double proPrice;
	

	@CreatedDate
	private LocalDateTime createAt;
	@CreatedBy
	private String createBy;

}
