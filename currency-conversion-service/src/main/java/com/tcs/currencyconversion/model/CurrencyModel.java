package com.tcs.currencyconversion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyModel {
	private String  fromCurrency;
	private String toCurrency;
	private double quantity;
}
