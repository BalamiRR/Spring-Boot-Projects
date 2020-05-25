package com.fuatkara.springboot.crud.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fuatkara.springboot.crud.entity.Employee;
import com.fuatkara.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//quick and dirty: inject employee dao
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping(path="/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	// /api/employees/{employeeId}  => Read a single employee
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee could not find" + employeeId);
		}
		
		return theEmployee;
	}


	// add mapping  for POST  /api/employees  => Create a new employee	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//they pass an id in JSON ... set id to 0
		//this is to force a save of new item .. instead of update
		
		theEmployee.setId(0);
		
		employeeService.insert(theEmployee);
		
		return theEmployee;
	}
	
	
	//add mapping for PUT / employees - update existing employee
	@PutMapping("/employees")
	public Employee updatingEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.insert(theEmployee);
		
		return theEmployee;
	}
	
	
	// add mapping for DELETE / employees/{employeeId} - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		if( tempEmployee == null) {
			throw new RuntimeException("There is no such a employee : " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
}