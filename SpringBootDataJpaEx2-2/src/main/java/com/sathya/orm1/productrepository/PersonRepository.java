package com.sathya.orm1.productrepository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.sathya.orm1.entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
