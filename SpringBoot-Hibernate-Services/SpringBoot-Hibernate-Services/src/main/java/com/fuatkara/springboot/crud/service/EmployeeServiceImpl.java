package com.fuatkara.springboot.crud.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fuatkara.springboot.crud.dao.EmployeeDAO;
import com.fuatkara.springboot.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	// Set up constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int saveId) {
		return employeeDAO.findById(saveId);
	}

	@Override
	@Transactional
	public void insert(Employee insertEmployee) {
		employeeDAO.insert(insertEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int deleteId) {
		employeeDAO.deleteById(deleteId);
	}

}
