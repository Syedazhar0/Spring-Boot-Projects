package com.sathya.orm.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDetails {
	
	private int proId;
	private String proName;
	private double proPrice;


}
