package com.app.empdirectory.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// add get mapping to find a particular employee
	@GetMapping("/employees/{employeeId}")
	public Employee getParticularEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeServive.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee with the given id is not found : " + employeeId);
		}
		return theEmployee;
	}

	// add post mapping to save or update a particular employee
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		System.out.println("adding new employee or updating it : " + newEmployee);
		// we are setting the id to 0, as it is a force to save employee not update
//		newEmployee.setId(0);
		Employee dbEmployee = employeeServive.save(newEmployee);
		return dbEmployee;
	}

}