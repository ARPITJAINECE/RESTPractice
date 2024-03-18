package com.app.empdirectory.empDAOinterface;

import java.util.List;

import com.app.empdirectory.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public Employee save(Employee newEmployee);

	public void deleteById(int theID);
}
