package com.ranga;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.ranga.config.ApplicationConfig;
import com.ranga.entity.Student;
import com.ranga.service.StudentService;



public class Main {


	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentService studentService = (StudentService)context.getBean("studentService");
		
		System.out.println("++++++++++++++++++++++");

		Student student = new Student();
	    student.setName("Вася");
		student.setSurname("Пупкин");
		studentService.createStudent(student);
		
		List<Student> list = studentService.getAll();
		for (Student student1 : list) {
			System.out.println(student1);
		}
		System.out.println(studentService.getStudent(1));
		
		context.close();

	}



}
