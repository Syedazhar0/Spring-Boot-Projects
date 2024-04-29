package com.tcs.springsecurity.customerrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.springsecurity.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByEmail(String email);
}
