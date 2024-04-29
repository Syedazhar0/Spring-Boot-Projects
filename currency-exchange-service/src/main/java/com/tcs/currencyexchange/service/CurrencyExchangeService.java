// CurrencyExchangeService.java
package com.tcs.currencyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.currencyexchange.entity.CurrencyExchange;
import com.tcs.currencyexchange.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private RestTemplate restTemplate;


    public CurrencyExchange getDataById(long id) {
        String conversionServiceUrl = "http://localhost:8080/api/conversion/get/" + id;
        ResponseEntity<CurrencyExchange> response = restTemplate.getForEntity(conversionServiceUrl, CurrencyExchange.class);
        CurrencyExchange model = response.getBody();
        
        if (model != null) {
            // Set exchange rate based on fromCurrency
            double exchangeRate = 0.0;
            switch (model.getFromCurrency()) {
                case "SAR":
                    exchangeRate = 22.22;
                    break;
                case "AED":
                    exchangeRate = 23.27;
                    break;
                case "KWD":
                    exchangeRate = 271.27;
                    break;
                case "AUD":
                    exchangeRate = 56.50;
                    break;
                case "USD":
                    exchangeRate = 81.78;
                    break;
                // Handle other currencies if necessary
                default:
                    // Set a default exchange rate or handle error
                    break;
            }
            
            // Set exchange rate and calculate total
            model.setExchangeRate(exchangeRate);
            model.setTotal(model.getQuantity() * exchangeRate);

            // Save or update in repository
            CurrencyExchange existingData = currencyExchangeRepository.findById(id).orElse(null);
            if (existingData != null) {
                existingData.setFromCurrency(model.getFromCurrency());
                existingData.setToCurrency(model.getToCurrency());
                existingData.setQuantity(model.getQuantity());
                existingData.setExchangeRate(model.getExchangeRate());
                existingData.setTotal(model.getTotal());
                return currencyExchangeRepository.save(existingData);
            } else {
                return currencyExchangeRepository.save(model);
            }
        } else {
            // Handle error or return null if appropriate
            return null;
        }
    }
}
