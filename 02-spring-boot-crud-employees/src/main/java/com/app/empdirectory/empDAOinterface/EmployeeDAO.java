package com.app.empdirectory.empDAOinterface;

import java.util.List;

import com.app.empdirectory.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
}
