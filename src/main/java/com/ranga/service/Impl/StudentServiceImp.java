package com.ranga.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ranga.service.StudentService;
import com.ranga.dao.StudentDao;
import com.ranga.entity.Student;

@Service("studentService")
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getAll() {

		return studentDao.getAll();
	}

	@Override
	public int createStudent(Student student) {

		return studentDao.createStudent(student);
	}

	@Override
	public Student getStudent(int id) {

		return studentDao.getStudent(id);
	}

	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
	}

	@Override
	public Student updateStudent(Student student) {

		return studentDao.updateStudent(student);
	}

}
