package com.schooldata.restapi.schoolData.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.schooldata.restapi.schoolData.Exceptions.Handler.WebExceptionsHandler;
import com.schooldata.restapi.schoolData.Exceptions.StudentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.schooldata.restapi.schoolData.Entity.StudentEntity;
import com.schooldata.restapi.schoolData.Repository.StudentRepository;
@Slf4j
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<StudentEntity> findAll(){
		return studentRepository.findAll();
	}
	public StudentEntity addStudent(StudentEntity student) {
	    return studentRepository.save(student);
	}
	public StudentEntity findById(Long id) throws StudentException {
		try {
			Optional<StudentEntity> student = studentRepository.findById(id);
			if(student.isEmpty()){
				throw new StudentException(HttpStatus.NOT_FOUND, "Student not found with id: ");
			}
			else{
				return student.get();
			}
        } catch (Exception e) {
			log.error("An error occurred while fetching the student with id: {}", id, e);
			throw new StudentException(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", e.getMessage());
		}
	}
	public void removeStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	public void updateResource(Long id, StudentEntity student) {
		Optional<StudentEntity> studentEntity = studentRepository.findById(id);
		if(studentEntity.isEmpty()){
			studentRepository.save(student);
		}
		else{
			StudentEntity updatedStudent = studentEntity.get();
			updatedStudent.setSurname(student.getSurname());
			updatedStudent.setName(student.getName());
			updatedStudent.setFatherName(student.getFatherName());
			updatedStudent.setMotherName(student.getMotherName());
			updatedStudent.setStandard(student.getStandard());
			updatedStudent.setStudentType(student.getStudentType());
			studentRepository.save(updatedStudent);
		}
	}

	

}
