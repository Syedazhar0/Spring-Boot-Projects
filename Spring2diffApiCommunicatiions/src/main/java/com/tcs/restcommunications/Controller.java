package com.tcs.restcommunications;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class Controller {
// this will display all carts details
    @GetMapping("/carts")
    public ResponseEntity<RestApiCarts> getAllCarts() {
        String url = "https://dummyjson.com/carts";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestApiCarts> response = restTemplate.getForEntity(url, RestApiCarts.class);
        return response;
    }
    
    // this is for specific one
    @GetMapping("/carts/{id}")
    public ResponseEntity<RestApiCarts> getCartById(@PathVariable int id) {
        String url = "https://dummyjson.com/carts/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestApiCarts> response = restTemplate.getForEntity(url, RestApiCarts.class);
        return response;
    }
    
    // postal rest api to check post offices by providing pincode
//    @GetMapping("/postal/{pincode}")
//    public ResponseEntity<PostOfficeDetails> getPostOfficeDetails(@PathVariable String pincode) {
//        String url = "https://api.postalpincode.in/pincode/" + pincode;
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<PostOfficeDetails> response = restTemplate.getForEntity(url, PostOfficeDetails.class);
//        return response;
//    }
    
    
    
    @GetMapping("/postal/{pincode}")
    public ResponseEntity<List<PostOfficeDetails>> getPostOfficeDetails(@PathVariable String pincode) {
        String url = "https://api.postalpincode.in/pincode/" + pincode;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PostOfficeDetails[]> responseEntity = restTemplate.getForEntity(url, PostOfficeDetails[].class);
        PostOfficeDetails[] responses = responseEntity.getBody();
        if (responses != null && responses.length > 0 && "Success".equals(responses[0].getDeliveryStatus())) {
            List<PostOfficeDetails> postOffices = responses[0].getPostOffice();
            return ResponseEntity.ok(postOffices);
        } else {
            // Handle error response
            return ResponseEntity.badRequest().build();
        }
    }
    
}
