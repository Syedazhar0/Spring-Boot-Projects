package com.tcs.currencyconversion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.currencyconversion.entity.CurrencyConversion;
import com.tcs.currencyconversion.repository.CurrencyRepository;

@Service
public class CurrencyCunversionService {
	@Autowired private CurrencyRepository currencyRepository;

	public CurrencyConversion getCurrencyById(long id) {
	
		return  currencyRepository.findById(id).get();
	}

	public List<CurrencyConversion> saveCurrency(List<CurrencyConversion> saveCurr) {
		
		return currencyRepository.saveAll(saveCurr);
	}

}
