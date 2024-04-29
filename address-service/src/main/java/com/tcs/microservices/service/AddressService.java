package com.tcs.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.microservices.entity.Address;
import com.tcs.microservices.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	public Address saveAddress(Address address) {
		return addressRepository.save(address);
		
	}

	public List<Address> findAddresses() {
		
		return addressRepository.findAll();
	}

	public Optional<Address> findById(long id) {
		
		return addressRepository.findById(id);
	}

}
