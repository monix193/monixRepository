package com.monix.jobber.controllers;

import java.util.Arrays;

import com.monix.jobber.domains.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {
	
	
	private static List<Student>  STUDENTS= Arrays.asList(
		new Student (1L, "jules diop"),
		new Student (2L, "mareme fall"),
		new Student (3L, "Malick sane"),
		new Student (4L, "fatou kane")
	);

    @GetMapping(value = "/hello")
	public String helloWorld(){
		return "Hello world ....";
	}

	@GetMapping
	public Student getStudent(@PathVariable  Long studentId){ 
		return STUDENTS.stream()
		.filter(student-> studentId.equals(student.getId()))
		.findFirst()
		.orElseThrow(() -> new IllegalStateException("Student "+studentId+" does not exists"));
	}
	
}