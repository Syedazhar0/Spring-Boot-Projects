package com.tcs.restcommunications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestApiCarts {
					  int id;
				      String title;
				      int  price;
					  int  quantity;
					  int  total;
					  double discountPercentage;
					  int  discountedPrice;
					  String  thumbnail;
				}
