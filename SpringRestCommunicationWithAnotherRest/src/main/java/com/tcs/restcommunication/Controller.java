package com.tcs.restcommunication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @GetMapping("/quotes")
    public ResponseEntity<RestApiQuotes[]> getQuotes() {
        String url = "https://dummyjson.com/quotes";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestApiQuotes[]> res = restTemplate.getForEntity(url, RestApiQuotes[].class);
        return res;
    }

	
//    @GetMapping("/quotes/{number}")
//    public ResponseEntity<RestApiQuotes> getQuotes1(@PathVariable int number) {
//        String url = "https://dummyjson.com/quotes/" + number; // Add a forward slash before {number}
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<RestApiQuotes> res = restTemplate.getForEntity(url, RestApiQuotes.class);
//        return res;
//    }

}
