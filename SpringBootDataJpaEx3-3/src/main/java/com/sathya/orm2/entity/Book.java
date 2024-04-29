package com.sathya.orm2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	private int isbn;
	private String name;
	private String author;
	private double price;
	

}























