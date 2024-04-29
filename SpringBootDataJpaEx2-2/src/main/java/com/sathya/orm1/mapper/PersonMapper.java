package com.sathya.orm1.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sathya.orm1.entity.Person;
import com.sathya.orm1.model.PersonDetails;

@Component
public class PersonMapper {
public  Person modelToEntityConversion(PersonDetails personDetails) {
	Person person = new Person();
	person.setFirstName(personDetails.getFirstName());
	person.setLastName(personDetails.getLastName());
	person.setEmail(personDetails.getEmail());
	person.setAge(personDetails.getAge());
	person.setCreateAt(LocalDateTime.now());
	person.setCreateBy(System.getProperty("user.name"));
	return person;
}
	
	public  List<Person> modelToEntityConversionlist(List<PersonDetails> personDetails){
		List<Person>   persons = new ArrayList<Person>();
		for(PersonDetails personDetails1 :personDetails ) {
			Person person2 = new Person();
			person2.setFirstName(personDetails1.getFirstName());
			person2.setLastName(personDetails1.getLastName());
			person2.setEmail(personDetails1.getEmail());
			person2.setAge(personDetails1.getAge());
			person2.setCreateAt(LocalDateTime.now());
			person2.setCreateBy(System.getProperty("user.name"));
			persons.add(person2);
				
		}
		return persons;
	}
	
}
