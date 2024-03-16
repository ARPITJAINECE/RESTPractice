package com.app.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.customException.StudentNotFoundException;
import com.app.demo.entity.Student;
import com.app.demo.errorResponse.StudentErrorResponse;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PostConstruct to load the students data...... done only once!!!!
	@PostConstruct
	public void loadData() {

		theStudents = new ArrayList<>();

		theStudents.add(new Student("Arpit", "Jain"));
		theStudents.add(new Student("Ruchi", "Jain"));
		theStudents.add(new Student("Neha", "Jain"));

	}

	// define endpoint for "/students"
	@GetMapping("/students")
	public List<Student> getListOfStudents() {

		// data has already been loaded using the loadData method above

		return theStudents;
	}

	// define endpoint for "/students/{studentId}" --> to return student of a
	// particular index
	@GetMapping("/students/{studentdId}")
	public Student getParticularStudent(@PathVariable int studentdId) {

		// data has already been loaded using the loadData method above

		// check the studentId against the List Size
		// for exception handling
		if ((studentdId >= theStudents.size()) || (studentdId < 0)) {
			throw new StudentNotFoundException("Student ID not found : " + studentdId);
		}

		return theStudents.get(studentdId);
	}

	// just commenting the lower part, as we are defining the global exception

	// Add an exception handler using @ExceptionHandler
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//
//		// creating a Student Error Response
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		// returning the ResponseEntity
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}

	// Add an exception handler to catch any type of exception (CATCH ALL)
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//
//		// creating a Student error response
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		// returning the student error response
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}

}
