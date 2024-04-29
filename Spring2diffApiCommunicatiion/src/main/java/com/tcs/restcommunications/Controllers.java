package com.tcs.restcommunications;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class Controllers {
	// this is for fetching all data from the that another api the url given two rest api communications
    @GetMapping("/carts")
    public ResponseEntity<RestApiQuotes> getCarts() {
        String url = "https://dummyjson.com/carts";
        RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<RestApiQuotes> response = restTemplate.getForEntity(url, RestApiQuotes.class);
            return response;
            // localhost url http://localhost:8080/api/carts
    }
    
    // this is for specific one by using path variable
    @GetMapping("/carts/{id}")
    public ResponseEntity<RestApiQuotes> getCarts1(@PathVariable int id) {
        String url = "https://dummyjson.com/carts/"+id;
        RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<RestApiQuotes> response = restTemplate.getForEntity(url, RestApiQuotes.class);
            // localhost url http://localhost:8080/api/carts/1
            return response;
    }
    
    // postoffice tracking
    
        @GetMapping("/postal/{pincode}")
        public ResponseEntity<PostalApiCommunication> getPostal(@PathVariable int pincode) {
            String url = "https://api.postalpincode.in/pincode/" + pincode;
            RestTemplate restTemplate = new RestTemplate();

            try {
                ResponseEntity<PostalApiCommunication> res = restTemplate.getForEntity(url, PostalApiCommunication.class);
                return res;
            } catch (Exception e) {
                // Handle the exception (log, return custom error response, etc.)
                e.printStackTrace();
                return ResponseEntity.status(500).build(); // Customize as needed
            }
        }
    
}
