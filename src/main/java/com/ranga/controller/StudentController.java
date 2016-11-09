package com.ranga.controller;


import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ranga.entity.Student;
import com.ranga.service.StudentService;

@Controller
public class StudentController {
	
	
	public StudentController() {
		System.out.println("StudentController Created");
	}
	
	
	@Autowired
	private StudentService studentService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
				
		return "index";
	}
	
	
	@RequestMapping(value = "/hello", method= RequestMethod.GET)
	public String helloword(ModelMap model ){
		model.addAttribute("message", "Hello World");
		return "hello";
		
	}
	

	@RequestMapping(value = "/studentList", method= RequestMethod.GET)
	public String getAll(ModelMap model ){
		List<Student> studentList = studentService.getAll();
		model.addAttribute("studentList", studentList);
		return "studentList";
		
	}
	
	

}
