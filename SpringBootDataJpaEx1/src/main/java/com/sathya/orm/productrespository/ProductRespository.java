//package com.sathya.orm.productrespository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.sathya.orm.entity.Product;
//
//public interface ProductRespository extends JpaRepository<Product, Integer> {
//	
//
//}
package com.sathya.orm.productrespository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathya.orm.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer> { // Corrected repository name
}
