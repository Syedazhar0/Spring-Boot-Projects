// CurrencyExchangeController.java
package com.tcs.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.tcs.currencyexchange.entity.CurrencyExchange;
import com.tcs.currencyexchange.service.CurrencyExchangeService;

@RestController
@RequestMapping("/api/conversion")
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;


    @GetMapping("/get/{id}")
    public CurrencyExchange getData(@PathVariable long id) {
        return currencyExchangeService.getDataById(id);
    }
}
