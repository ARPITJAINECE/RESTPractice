package com.app.empdirectory.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.empdirectory.empDAOinterface.EmployeeDAO;
import com.app.empdirectory.entity.Employee;
import com.app.empdirectory.serviceInterface.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// private EmployeeDAO employeeDAO; since we are using the service layer, so now
	// we need to inject Service layer
	// inject employeeDAO using constructor injection

	private EmployeeService employeeServive;

//	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
//		employeeDAO = theEmployeeDAO;
//	}

	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeServive = theEmployeeService;
	}

	// expose the "/employees" and return a list of employees

	@GetMapping("/employees")
	public List<Employee> getListOfEmployees() {
//		return employeeDAO.findAll();
		return employeeServive.findAll();
	}

}
