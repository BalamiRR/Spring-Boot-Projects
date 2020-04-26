package com.fuatkara.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuatkara.dao.StudentDao;
import com.fuatkara.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;

	public Collection<Student> getAllStudents(){
		return this.studentDao.getAllStudents();   
	}

	public Student getStudentById(int id) {
		return this.studentDao.getStudentById(id);
	}
	
	public void removePersonById(int id) {
		this.studentDao.removePersonById(id);		
	}
	
	public void updatingPerson(Student student) {
		this.studentDao.updatingPerson(student);
	}
	
	public void insertPerson(Student student) {
		this.studentDao.insertPersonToDb(student);
	}
	
}
