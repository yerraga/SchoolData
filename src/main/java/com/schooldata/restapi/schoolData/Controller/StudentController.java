package com.schooldata.restapi.schoolData.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity student) {
		HttpStatus status = HttpStatus.CREATED;
		return new ResponseEntity<>(studentService.addStudent(student), status);

	}

	@GetMapping("students/{id}")
	public StudentEntity findById(@PathVariable Long id) {
		return studentService.findById(id);

	}

	@DeleteMapping("students/{id}")
	public void removeStudent(@PathVariable Long id) {
	studentService.removeStudent(id);
	}
	
	@PutMapping("updateStudent/{id}")
	public void updateResource(@RequestBody StudentEntity student, @PathVariable Long id){
		studentService.updateResource(id, student);
	}


}
