package com.sathya.orm1.ProductClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm1.entity.Person;
import com.sathya.orm1.mapper.PersonMapper;
import com.sathya.orm1.model.PersonDetails;
import com.sathya.orm1.productrepository.PersonRepository;

@Component
public class PersonClient1 implements CommandLineRunner {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PersonMapper personMapper;
	@Override
	public void run(String... args) throws Exception {
		PersonDetails personDetails = new PersonDetails();
		personDetails.setFirstName("syed");
		personDetails.setLastName("azhar");
		personDetails.setEmail("syedazhar152003@gmail.com");
		personDetails.setAge("20");
		
		Person person = personMapper.modelToEntityConversion(personDetails);
		// these are predefined methods save saveall ....... etc
		personRepository.save(person);
		
		// save all method
		PersonDetails p1 = new PersonDetails();
		p1.setFirstName("hello");
		p1.setLastName("world");
		p1.setEmail("helloworld@gmail.com");
		p1.setAge("21");
		
		PersonDetails p2 = new PersonDetails();
		p2.setFirstName("welcome to ");
		p2.setLastName("java full stack");
		p2.setEmail("javafullstack@gmail.com");
		p2.setAge("22");
		
		List<PersonDetails> details =List.of(p1,p2);
		
		List<Person> persons =personMapper.modelToEntityConversionlist(details);
		personRepository.saveAll(persons);
		
		
	}	

}
