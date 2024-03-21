package com.app.empdirectory.empRepoJPAInteface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.empdirectory.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//no need to write any other code here , as spring handles it all
	

}
