package com.ranga.service;

import java.util.List;
import com.ranga.entity.Student;

public interface StudentService {

	public List<Student> getAll();
	public int createStudent(Student student);
	public Student getStudent(int id);
	public void deleteStudent(int id);
	public Student updateStudent(Student student);
	
}
