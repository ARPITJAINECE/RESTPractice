package com.app.empdirectory.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.empdirectory.empDAOinterface.EmployeeDAO;
import com.app.empdirectory.entity.Employee;
import com.app.empdirectory.serviceInterface.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// inject the EmployeeDAO -----> constructor injection

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Transactional
	@Override
	public Employee save(Employee newEmployee) {
		return employeeDAO.save(newEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theID) {
		employeeDAO.deleteById(theID);
	}
}
