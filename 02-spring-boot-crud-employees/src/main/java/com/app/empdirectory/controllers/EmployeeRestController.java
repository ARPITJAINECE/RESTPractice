package com.app.empdirectory.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.empdirectory.empDAOinterface.EmployeeDAO;
import com.app.empdirectory.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// inject employeeDAO using constructor injection

	private EmployeeDAO employeeDAO;

	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	// expose the "/employees" and return a list of employees

	@GetMapping("/employees")
	public List<Employee> getListOfEmployees() {
		return employeeDAO.findAll();
	}

}
