package com.sathya.RestApi2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private int isbn;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;

}
