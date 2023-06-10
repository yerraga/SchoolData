package com.schooldata.restapi.schoolData.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
	public StudentEntity findById(Long id) {
		return studentRepository.getById(id);
	}
	public void removeStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	public void updateResource(Long id, StudentEntity student) {
		List<StudentEntity> students = studentRepository.findAll();
		Optional<StudentEntity> updatingResource = students.stream().filter(studentId -> studentId.getId().equals(id)).findFirst();
		if (updatingResource.isPresent()) {
			student.setId(id);
			student.setSurname(student.getSurname());
			student.setName(student.getName());
			student.setFatherName(student.getFatherName());
			student.setMotherName(student.getMotherName());
			studentRepository.save(student);
		}
		else if (updatingResource.isEmpty()) {
			student.setId(id);
			student.setSurname(student.getSurname());
			student.setName(student.getName());
			student.setFatherName(student.getFatherName());
			student.setMotherName(student.getMotherName());
			studentRepository.save(student);
		}
	}

	

}
