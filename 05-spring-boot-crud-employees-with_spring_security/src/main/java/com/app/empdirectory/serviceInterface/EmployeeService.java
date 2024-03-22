package com.app.empdirectory.serviceInterface;

import java.util.List;

import com.app.empdirectory.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public Employee save(Employee newEmployee);

	public void deleteById(int theID);

}
