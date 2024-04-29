package com.tcs.microservices2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.microservices2.entity.Student;
import com.tcs.microservices2.model.StudentDetails;
import com.tcs.microservices2.service.StudentService;
import com.tcs.microservices2.studentresponse.StudentResponse;

@RestController
@RequestMapping("/api/microservices")
public class StudentController {
@Autowired
StudentService studentService;

@PostMapping("/savestudents")
public Student saveStudent(@RequestBody StudentDetails studentDetails) {
	Student student = new Student();
	student.setFirstName(studentDetails.getFirstName());
	student.setLastName(studentDetails.getLastName());
	student.setEmail(studentDetails.getEmail());
	return studentService.save(student);
	
}

@GetMapping("/getall")
public List<Student> findAllStudents(){
	return studentService.findAllStudents();
	
}

@GetMapping("/getbyid/{id}")
public  Optional<Student> findById(@PathVariable long id) {
	return studentService.findById(id);
	
}

@GetMapping("/getById/{id}")
public StudentResponse getById(@PathVariable Long id) {
	return studentService.getStudentById(id);
}
}
