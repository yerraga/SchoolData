package com.schooldata.restapi.schoolData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schooldata.restapi.schoolData.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

	boolean existsBySurname(String surname);

}
