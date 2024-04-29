package com.tcs.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.web.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
