package com.app.empdirectory.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.empdirectory.empRepoJPAInteface.EmployeeRepository;
import com.app.empdirectory.entity.Employee;
import com.app.empdirectory.serviceInterface.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// inject the EmployeeDAO -----> constructor injection

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// no employee is found with that ID
			throw new RuntimeException("didn't find any employee with empID : " + theId);
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}

	@Override
	public void deleteById(int theID) {
		employeeRepository.deleteById(theID);
	}
}
