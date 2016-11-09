package com.ranga.tests;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ranga.config.ApplicationConfigTest;
import com.ranga.entity.Student;
import com.ranga.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfigTest.class })
public class StudentTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void getAllTest() throws Exception {
		List<Student> list = studentService.getAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);

	}

	@Test
	public void createStudentTest() {
		List<Student> list = studentService.getAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		int oldSize = list.size();

		Student student = new Student();
		student.setName("Вася");
		student.setSurname("Пупкин");
		studentService.createStudent(student);

		list = studentService.getAll();
		int newSize = list.size();
		Assert.assertNotNull(list);
		Assert.assertEquals(newSize, oldSize + 1);

		Student s = list.get(list.size() - 1);
		String name = s.getName();
		String surname = s.getSurname();
		int id = s.getId();

		Assert.assertTrue(id > 0);
		Assert.assertEquals("Вася", name);
		Assert.assertEquals("Пупкин", surname);

	}

	@Test
	public void getStudentTest() {

		List<Student> list = studentService.getAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Student s = list.get(0);
		Student student = studentService.getStudent(s.getId());
		Assert.assertNotNull(student);
		Assert.assertTrue(student.getId() > 0);
	}

	@Test
	public void deleteStudent() {
		Student student = new Student();
		student.setName("Вася");
		student.setSurname("Пупкин");
		studentService.createStudent(student);

		List<Student> list = studentService.getAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		int oldSize = list.size();
		Student s = list.get(list.size() - 1);
		studentService.deleteStudent(s.getId());
		list = studentService.getAll();
		int newSize = list.size();
		Assert.assertNotNull(list);
		Assert.assertEquals(newSize, oldSize - 1);
	}

	@Test
	public void updateStudent() {
		Student student = new Student();
		student.setName("Вася");
		student.setSurname("Пупкин");
		studentService.createStudent(student);

		List<Student> list = studentService.getAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Student s = list.get(list.size() - 1);
		s.setName("Катя");
		s.setSurname("Иванова");
		studentService.updateStudent(s);

		List<Student> listNew = studentService.getAll();
		Assert.assertNotNull(listNew);
		Assert.assertTrue(listNew.size() > 0);

		Student studentNew = listNew.get(list.size() - 1);

		String nameNew = studentNew.getName();
		String surnameNew = studentNew.getSurname();
		int studentIdNew = studentNew.getId();

		Assert.assertEquals(s.getId(), studentIdNew);
		Assert.assertEquals("Катя", nameNew);
		Assert.assertEquals("Иванова", surnameNew);

	}

}
