
package com.sathya.orm.productrespository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sathya.orm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> { // Corrected repository name
}
