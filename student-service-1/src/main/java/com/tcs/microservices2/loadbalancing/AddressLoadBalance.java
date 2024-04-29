package com.tcs.microservices2.loadbalancing;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value = "address-service")
public class AddressLoadBalance {

	@LoadBalanced
	@Bean
	public Feign.Builder builder(){
		return Feign.builder();
	}
}
