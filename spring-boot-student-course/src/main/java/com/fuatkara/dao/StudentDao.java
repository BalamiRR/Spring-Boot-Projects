package com.fuatkara.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fuatkara.entity.Student;

@SuppressWarnings("serial")
@Repository
public class StudentDao {

	private static Map<Integer, Student> students;
	
	static {         //put(1 => keys, new Students => values'dur)
		
		students = new HashMap<Integer, Student>(){
			{
				put(1, new Student(1, "Balamir Black", "Computer Science"));
				put(2, new Student(2, "Smith John", "Computer Engineering"));
				put(3, new Student(3, "Thomas Neo", "Techniqer"));
			}
		};
	}
	
	@SuppressWarnings("static-access")
	public Collection<Student> getAllStudents(){
		return this.students.values();   // values sagdakiler yukarida aciklama
	}

	@SuppressWarnings("static-access")
	public Student getStudentById(int id) {
		return this.students.get(id);
	}
	
	@SuppressWarnings("static-access")
	public void removePersonById(int id) {
		this.students.remove(id);
	}
	
	public void updatingPerson(Student student) {
		Student s = students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
		students.put(student.getId(),student);  //put(1, new Student(3,"Bala","Maths");
	}
	
	public void insertPersonToDb(Student student) {
		this.students.put(student.getId(), student);
	}
}