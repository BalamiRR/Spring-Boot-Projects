package com.fuatkara.springboot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fuatkara.springboot.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// thats it  .. no need to write any code
	// Buraya herhangi bir kod yazmicaz o otomatik olarak bize CRUD yapmamizi sagliyor.
}
