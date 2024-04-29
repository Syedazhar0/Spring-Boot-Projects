package com.sathya.orm.producclient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.entity.Product;
import com.sathya.orm.model.ProductDetails;
import com.sathya.orm.productmapper.ProductMapper;
import com.sathya.orm.productrespository.ProductRepository;

@Component
public class ProductClient implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository; 
    
    @Autowired
    ProductMapper mapper;

    @Override
    public void run(String... args) throws Exception {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProId(1001);
        productDetails.setProName("Chintapandu");
        productDetails.setProPrice(220);
        
        Product product = mapper.modelToEntityConversion(productDetails);
        // save method to add single product details
        productRepository.save(product);
        
      ProductDetails p1 =new ProductDetails() ;
      p1.setProId(111);
      p1.setProName("sugar");
      p1.setProPrice(20);
      
      ProductDetails p2 =new ProductDetails() ;
      p2.setProId(222);
      p2.setProName("salt");
      p2.setProPrice(120);
      
      List<ProductDetails>productDetails2 =List.of(p1,p2);
      //conversion process
      //saveall method used to save multiple values
      List<Product>products =mapper.modelToEntityConversion1( productDetails2);
      productRepository.saveAll(products);
      
      //findby id used to find the specific product 
      
      productRepository.findById(111);
      
      List<Product> products2=  productRepository.findAll();
      for(Product pro : products2) {
    	  System.out.println(pro);
      }
      
   boolean bool=  productRepository.existsById(111);
   System.out.println(bool);
      
   System.out.println(  productRepository.count());
      
   productRepository.deleteById(222);
   
//   productRepository.deleteAll();
   
   Optional<Product> p =  productRepository.findById(111);
   if (p.isPresent()) {
	   System.out.println(p);
	
}else {
	System.out.println("product not available");
}
      
      
      
      
      
    }
}
