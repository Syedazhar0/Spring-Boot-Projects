package com.tcs.microservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.microservices.entity.Address;
import com.tcs.microservices.model.AddressDetails;
import com.tcs.microservices.service.AddressService;

@RestController
@RequestMapping("/api/microservices")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	
	
	@PostMapping("/addresses")
    public void setAddressData(@RequestBody AddressDetails addressDetails) {
        Address address = new Address();
        address.setStreet(addressDetails.getStreet());
        address.setCity(addressDetails.getCity());
        addressService.saveAddress(address);
    }
	
	@GetMapping("/getdata")
	public List<Address> findAddresses(){
		return addressService.findAddresses();
	}
	@GetMapping("/getById/{id}")
	public Optional<Address> findById(@PathVariable long id) {
		return addressService.findById(id);
		
	}
	
	

}
