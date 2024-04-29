package com.tcs.microservices2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.microservices2.AddressFeignClient;
import com.tcs.microservices2.addressresponse.AddressResponse;
import com.tcs.microservices2.commonservice.CommonService;
import com.tcs.microservices2.entity.Student;
import com.tcs.microservices2.repository.StudentRepository;
import com.tcs.microservices2.studentresponse.StudentResponse;

@Service
public class StudentService {
	@Autowired
	StudentRepository  studentRepository;
	
//	@Autowired
//	RestTemplate restTemplate;
	
	//@Autowired
	//AddressFeignClient addressFeignClient; before common service or create separate method
	// @autowired in this class but this is not so created separate class and method
	
	
//	@Autowired
//	WebClient webClient;
	
	
	// autowired new class here for object to get details
	@Autowired
	private CommonService commonService;
	
	
	@Value("${address.service.url}")
	String baseUrl;

	public Student save(Student student) {
		
		return studentRepository.save(student) ;
	}

	public List<Student> findAllStudents() {
		
		return studentRepository.findAll();
	}

	public Optional<Student> findById(long id) {
		
		return studentRepository.findById(id);
	}
  
//	public StudentResponse getStudentById(long id) {
	
	//first approach of rest api communication using resttemplate
	// total dependencies in this application is lombok spring web spring data jpa h2 database dev tools  spring reactive web
	//  add spring security if required
	// if you forgot to add any dependency goto spring boot initializer and search for dependencies
//		Student student = studentRepository.findById(id).get();
//		AddressResponse addressResponse=
//				restTemplate.getForObject(baseUrl+id, AddressResponse.class);
//		StudentResponse studentResponse = new StudentResponse();
//		studentResponse.setId(student.getId());
//		studentResponse.setFirstName(student.getFirstName());
//		studentResponse.setLastName(student.getLastName());
//		studentResponse.setEmail(student.getEmail());
//		studentResponse.setAddressResponse(addressResponse);
//		
//		return studentResponse;
//	}
	
	
	
	
//	public StudentResponse getStudentById(long id) {
	
	//second approach of rest api communication using webclient
	// if you are using webclient add the spring reactive web dependency 
	//if you forgot to add it at the time of creating spring boot application
	
//		Student student = studentRepository.findById(id).get();
//		AddressResponse  addressResponse =	webClient.get()
//				.uri("/getById/" + id)
//				.retrieve()
//				.bodyToMono(AddressResponse.class)
//				.block();
//		StudentResponse studentResponse = new StudentResponse();
//		studentResponse.setId(student.getId());
//		studentResponse.setFirstName(student.getFirstName());
//		studentResponse.setLastName(student.getLastName());
	//studentResponse.setEmail(student.getEmail());
//		studentResponse.setAddressResponse(addressResponse);
//		
//		return studentResponse;
//	}
	
	public StudentResponse getStudentById(  long id) {
		Student student = studentRepository.findById(id).get();
		// if you are using feignClient  add the spring OpenFeign dependency 
//third approach of rest api communication using feignClient
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setId(student.getId());
		studentResponse.setFirstName(student.getFirstName());
		studentResponse.setLastName(student.getLastName());
		studentResponse.setEmail(student.getEmail());
		studentResponse.setAddressResponse(commonService.getAddressById(id));
		
		return studentResponse;
	}

}
