package com.tcs.microservices2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.microservices2.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
