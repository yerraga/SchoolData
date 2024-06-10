package com.schooldata.restapi.schoolData.Controller;

import java.util.List;

import com.schooldata.restapi.schoolData.Exceptions.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.schooldata.restapi.schoolData.Entity.StudentEntity;
import com.schooldata.restapi.schoolData.Service.StudentService;

@RestController
@RequestMapping("/api/V1/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<List<StudentEntity>> findAll() {
		return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);

	}

	@PostMapping("/addStudent")
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity student) {
		HttpStatus status = HttpStatus.CREATED;
		return new ResponseEntity<>(studentService.addStudent(student), status);

	}

	@GetMapping("students/{id}")
	public StudentEntity findById(@PathVariable Long id) throws StudentException {
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
