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

	@Override
	public Employee findById(int theId) {

		// get the employee with the id
		Employee theEmployee = entityManager.find(Employee.class, theId);

		// return that employee
		return theEmployee;
	}

	@Override
	public Employee save(Employee newEmployee) {
		// save the employee or update the employee
		Employee dbEmployee = entityManager.merge(newEmployee);

		// return that dbEmployee
		return dbEmployee;
	}

	@Override
	public void deleteById(int theID) {
		// find the employee on the basis of the ID
		Employee findEmployee = entityManager.find(Employee.class, theID);

		// now delete that employee
		entityManager.remove(findEmployee);
	}

}
