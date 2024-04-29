package com.tcs.microservices2;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.microservices2.addressresponse.AddressResponse;

//@FeignClient(name = "address-service", url = "${address.service.url}",path = "/api/microservices")


//change the url to value when u are working with eureka server 
// place the application name insted of placing url see below see above with url the above is previous ex communication through urls
// the communication happen with application names goto application.prorperty and
// copy the application name and place it into value
@FeignClient(name = "address-service", value="address-service", path = "/api/microservices")
@EnableFeignClients
@EnableDiscoveryClient
public interface AddressFeignClient {
    @GetMapping("/getById/{id}")
    AddressResponse getAddressById(@PathVariable("id") Long id);
    //url:http://localhost:8082/api/microservices/getById/1
}
