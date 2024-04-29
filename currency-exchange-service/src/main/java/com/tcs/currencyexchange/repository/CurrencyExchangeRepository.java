package com.tcs.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.currencyexchange.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

}
