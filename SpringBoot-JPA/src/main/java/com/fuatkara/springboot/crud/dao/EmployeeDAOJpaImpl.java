package com.fuatkara.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fuatkara.springboot.crud.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query theQuery = 
				entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int saveId) {

		Employee employees = entityManager.find(Employee.class,saveId);
		
		return employees;
	}

	@Override
	public void insert(Employee theEmployee) {
		//Burada update ve inserti beraber yapiyoruz
		
		// merge => if id==0 then insert/save, else update
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with from db .. so we can get generated id for save/insert 
		theEmployee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteById(int deleteId) {
		
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", deleteId);
		
		theQuery.executeUpdate();
		
		//entityManager.remove(deleteId);
	}

}
