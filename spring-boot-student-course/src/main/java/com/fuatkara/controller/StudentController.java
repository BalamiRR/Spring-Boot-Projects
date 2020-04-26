package com.fuatkara.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuatkara.entity.Student;
import com.fuatkara.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(path = "/getAllStudents")
	public Collection<Student> getAllStudents(){
		return studentService.getAllStudents();   // values sagdakiler yukarida aciklama
	}
	
	@GetMapping(path = "/{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		return this.studentService.getStudentById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deletStudentById(@PathVariable("id") int id) {
		studentService.removePersonById(id);
	}
	
	@PutMapping
	public void updateStudentBy(@RequestBody Student student) {
		studentService.updatingPerson(student);
	}
	
	@PostMapping
	public void insertStudent(@RequestBody Student student) {
		studentService.insertPerson(student);
	}

}
