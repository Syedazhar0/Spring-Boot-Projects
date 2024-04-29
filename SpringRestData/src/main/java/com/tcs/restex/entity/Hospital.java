package com.tcs.restex.entity;

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
public class Hospital {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)// auto generate ids
	private Long id;
	private String name;
	private String location;
	private double rating;
}
