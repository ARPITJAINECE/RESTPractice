package com.app.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/students"
	@GetMapping("/students")
	public List<Student> getListOfStudents() {

		List<Student> theStudents = new ArrayList<>();

		theStudents.add(new Student("Arpit", "Jain"));
		theStudents.add(new Student("Ruchi", "Jain"));
		theStudents.add(new Student("Neha", "Jain"));

		return theStudents;
	}

}
