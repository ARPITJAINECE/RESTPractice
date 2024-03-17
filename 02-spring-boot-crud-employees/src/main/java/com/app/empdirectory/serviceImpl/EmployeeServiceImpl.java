package com.app.empdirectory.serviceImpl;

import java.util.List;

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
}
