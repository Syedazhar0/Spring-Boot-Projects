package com.tcs.restcommunications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// website for dummy quotes or carts of etc https://dummyjson.com/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestApiQuotes {
	int id;
	String title;
	int price;
	int quantity;
	int total;
	double discountPercentage;
	int discountedPrice;
	String thumbnail;
}
