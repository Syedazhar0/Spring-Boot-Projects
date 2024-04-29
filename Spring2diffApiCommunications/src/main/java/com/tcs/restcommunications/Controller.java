package com.tcs.restcommunications;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class Controller {
    
    @GetMapping("/carts")
    public ResponseEntity<String> getCarts() {
        String url = "https://dummyjson.com/carts";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }
    
    
    
    @GetMapping("/carts/{id}")
    public ResponseEntity<String> getCartss(@PathVariable int id) {
        String url = "https://dummyjson.com/carts/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }
    
    @GetMapping("/postal/{pincode}")
    public ResponseEntity<String> getPost(@PathVariable int pincode) {
        String url = "https://api.postalpincode.in/pincode/" + pincode;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }

    @GetMapping("/weather/{cityName}")
    public ResponseEntity<String> getWeather(@PathVariable String cityName){
    	String url="http://api.weatherapi.com/v1/current.json?key=ee7e268a0d5f449bad2125237240804&q="+ cityName +"&aqi=no";
    	RestTemplate restTemplate =new RestTemplate();
    	ResponseEntity< String> res = restTemplate.getForEntity(url, String.class);
    	return res;
    	
    }
    

}
















//package com.tcs.restcommunications;
//
//import lombok.Data;
//import java.util.List;
//
//@Data
//public class CartItem {
//    private int id;
//    private String title;
//    private double price;
//    private int quantity;
//    private double total;
//    private double discountPercentage;
//    private double discountedPrice;
//    private String thumbnail;
//}
//
//@Data
//public class Cart {
//    private int id;
//    private List<CartItem> products;
//}
//
//package com.tcs.restcommunications;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RequestMapping("/api")
//@RestController
//public class Controller {
//    
//    @GetMapping("/carts")
//    public ResponseEntity<List<Cart>> getCarts() {
//        String url = "https://dummyjson.com/carts";
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<Cart>> response = restTemplate.exchange(
//            url, 
//            HttpMethod.GET, 
//            null, 
//            new ParameterizedTypeReference<List<Cart>>() {}
//        );
//        return response;
//    }
//}
