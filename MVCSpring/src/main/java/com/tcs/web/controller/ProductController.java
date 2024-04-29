package com.tcs.web.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.web.model.Product;
import com.tcs.web.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
	 private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired ProductService productService;
	
	 // Display the product form
    @GetMapping("/getform")
    public String showProductForm(  Model model) {
    	Product product =new Product();
    	product.setMadeIn("IN");
    	
        model.addAttribute("product", product);
        return "new-product";
    }

    
 // Save the product data
    @PostMapping("/saveproduct")
    public String saveProduct(
            @Valid @ModelAttribute Product product,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            logger.error("Validation failed while saving product");
            // If validation fails, return to the form page with validation errors
            model.addAttribute("product", product); // Add the product back to the model
            return "new-product"; // Return to the form page
        }

        // If no validation errors, proceed with saving the product
        boolean status = productService.createProduct(product);
        if (status) {
            redirectAttributes.addFlashAttribute("savemessage", true);
            logger.info("Product saved successfully");
            return "redirect:/products/getproducts";
        } else {
            redirectAttributes.addFlashAttribute("savemessage", false);
            logger.error("Failed to save product");
            return "redirect:/products/getproducts";
        }
		
    }	
    
    //edit the product data
      @PostMapping("/updateproduct")
      public String updateProduct(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
    	  boolean status = productService.updateProductById(product);
    	  if(status) {
    		  redirectAttributes.addFlashAttribute("editmessage",true );
    		  logger.info("Product updated successfully");
    		  return "redirect:/products/getproducts";
    	  }
    	  else {
    		  redirectAttributes.addFlashAttribute("editMessage",false);
    		  logger.error("Failed to update product");
  			return "redirect:/products/getproducts";
    	  }
      }

    //getting list of products
    @GetMapping("/getproducts")
	public String getAllProducts(Model model)
	{
		List<Product> products = productService.getAllProducts();
		
		model.addAttribute("products",products);
		logger.info("Displayed product list");
		return "product-list";
	}
  
    //deleting a product by its id 
    @GetMapping("/delete/{proId}")
	public String depeteProduct(@PathVariable Long proId,RedirectAttributes redirectAttributes)
	{
		productService.deleteProduct(proId);
		redirectAttributes.addFlashAttribute("deletemessage",true);
		 logger.info("Product deleted successfully");
		return "redirect:/products/getproducts";
	}
    
    //editing a product 
    @GetMapping("/edit/{proId}")
	public String editProductById(@PathVariable Long proId,Model model,RedirectAttributes redirectAttributes)
	{
		Optional<Product> product = productService.getProductById(proId);
		redirectAttributes.addFlashAttribute("editmessage", true);
		model.addAttribute("product",product);
		logger.info("Displayed edit form for product with id: " + proId);
		return "edit-form";
	}


}