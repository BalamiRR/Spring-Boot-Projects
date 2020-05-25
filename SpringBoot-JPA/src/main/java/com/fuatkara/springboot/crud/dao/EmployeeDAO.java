package com.fuatkara.springboot.crud.dao;

import java.util.List;
import com.fuatkara.springboot.crud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int saveId);
	
	public void insert(Employee theEmployee);
	
	public void deleteById(int deleteId);
	
	
	
}