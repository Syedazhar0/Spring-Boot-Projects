package com.tcs.currencyexchange.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {
	@Id
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private double quantity;
    private double exchangeRate;
    private double total;
}
