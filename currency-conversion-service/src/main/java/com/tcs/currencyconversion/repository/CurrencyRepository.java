package com.tcs.currencyconversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tcs.currencyconversion.entity.CurrencyConversion;

public interface CurrencyRepository extends JpaRepository<CurrencyConversion, Long>{

	

}
