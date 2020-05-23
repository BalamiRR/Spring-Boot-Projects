package com.fuatkara.springboot.crud.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.fuatkara.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}


	@Override
	@Transactional   //Hibernate deki transactionlar
	public List<Employee> findAll() {

		//get the currenct hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
	
		//return the results		
		return employees;
	}


	@Override
	public Employee findById(int findId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//find the id
		Employee employee = currentSession.get(Employee.class, findId);
		
		//return id
		return employee;
	}


	@Override
	public void insert(Employee insertEmployee) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		currentSession.saveOrUpdate(insertEmployee);
		
	}

	
	@Override
	public void deleteById(int deleteId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", deleteId);
		
		theQuery.executeUpdate();
		
		//delete object with primary key
		//currentSession.delete(deleteId);
	}
	
}