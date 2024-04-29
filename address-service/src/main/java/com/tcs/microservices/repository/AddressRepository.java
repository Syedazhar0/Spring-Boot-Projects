package com.tcs.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.microservices.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
