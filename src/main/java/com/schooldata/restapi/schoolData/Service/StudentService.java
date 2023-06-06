package com.schooldata.restapi.schoolData.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schooldata.restapi.schoolData.Entity.StudentEntity;
import com.schooldata.restapi.schoolData.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<StudentEntity> findAll(){
		return studentRepository.findAll();
	}
	public StudentEntity addStudent(StudentEntity student) {
	    return studentRepository.save(student);
	}

	

}
