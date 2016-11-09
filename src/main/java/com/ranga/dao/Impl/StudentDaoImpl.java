package com.ranga.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ranga.dao.StudentDao;
import com.ranga.entity.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	
	public List<Student> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Student");
		return query.list();

	}

	@Override
	
	public int createStudent(Student student) {

		return (int) sessionFactory.getCurrentSession().save(student);
	}

	@Override
	
	public Student getStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = (Student) session.get(Student.class, id);
		return  student;
	}

	@Override
	
	public void deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = (Student) session.get(Student.class, id);
		session.delete(student);
	}

	@Override
	
	public Student updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
		return student;

	}

}
