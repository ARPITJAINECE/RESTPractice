package com.app.empdirectory.empDAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.app.empdirectory.empDAOinterface.EmployeeDAO;
import com.app.empdirectory.entity.Employee;

@Repository
public class EmployyeDAOImpl implements EmployeeDAO {

	// define the field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	public EmployyeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

		// execute query and get the result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

}
