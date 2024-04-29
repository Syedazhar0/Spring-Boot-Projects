package com.tcs.microservices2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class StudentService1Application {
    public static void main(String[] args) {
        SpringApplication.run(StudentService1Application.class, args);
    }

	
//	@Bean
//	   public RestTemplate restTemplate(){
//		return new RestTemplate();
    // url: http://localhost:8082/api/microservices/getstudentbyid/1
//	}
//	
	
//	@Value("${address.service.url}")
//	private String addressServiceUrl;
//	@Bean
//	public WebClient webClient () {
//		WebClient webClient =WebClient.builder()
//									  .baseUrl(addressServiceUrl)
//									  .build();
//		return webClient;
//	}

}
