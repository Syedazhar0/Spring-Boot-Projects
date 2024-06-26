package com.tcs.currencyconversion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.currencyconversion.entity.CurrencyConversion;
import com.tcs.currencyconversion.model.CurrencyModel;
import com.tcs.currencyconversion.service.CurrencyCunversionService;

@RestController
@RequestMapping("/api/conversion")
public class CurrencyController {
	
	@Autowired private CurrencyCunversionService currencyCunversionService;
	
	
	
	@PostMapping("/saveall")
	public List<CurrencyConversion> save(@RequestBody List<CurrencyModel> currencyModel){
		List<CurrencyConversion> saveCurr=new  ArrayList<CurrencyConversion>();
		for (CurrencyModel currencyModel2 : currencyModel) {
			
		CurrencyConversion conversion = new CurrencyConversion();
		conversion.setFromCurrency( currencyModel2.getFromCurrency());
		conversion.setToCurrency( currencyModel2.getToCurrency());
		conversion.setQuantity( currencyModel2.getQuantity());
	     saveCurr.add(conversion);
		}
		return  currencyCunversionService.saveCurrency(saveCurr);
	}
	
	@GetMapping("/get/{id}")
	public CurrencyConversion getCurrency(@PathVariable  long id){
				return currencyCunversionService.getCurrencyById(id);
		
	}
	
	

}
