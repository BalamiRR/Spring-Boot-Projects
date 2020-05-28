package com.fuatkara.springboot.crud.service;

import java.util.List;
import com.fuatkara.springboot.crud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int saveId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int deleteId);
	
}