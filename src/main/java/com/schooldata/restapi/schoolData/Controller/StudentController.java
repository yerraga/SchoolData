package com.schooldata.restapi.schoolData.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.schooldata.restapi.schoolData.Entity.StudentEntity;
import com.schooldata.restapi.schoolData.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public List<StudentEntity> findAll() {
		return studentService.findAll();
		
	}
	@PostMapping("/addStudent")
	public StudentEntity addStudent(@RequestBody StudentEntity student) {
		//StudentEntity student = new StudentEntity();
		return studentService.addStudent(student);
		
	}
	
}
