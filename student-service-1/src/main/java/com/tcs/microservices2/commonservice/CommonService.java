package com.tcs.microservices2.commonservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.microservices2.AddressFeignClient;
import com.tcs.microservices2.addressresponse.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	
	long count = 1;
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	//circute brakers are used when two are more services are communicating each other
	// if any service down then it leads to cascading failure which will effect other services
	// whole application will fails to prevent from this failure  we use circuit breakers
	// if any service is having issue then it will stop the requests to it so the other services 
	// keep running smoothly
	@CircuitBreaker(name = "addressService" , fallbackMethod = "fallbackGetAddress")// this annotation contains 2 args one name and method
	public AddressResponse getAddressById(long id) {
		
		logger.info("count = " + count);
		count++;  
		
		return addressFeignClient.getAddressById(id);
		
	}
	
	public AddressResponse fallbackGetAddress(long id) {
		
		return new AddressResponse();
		
	}

}
