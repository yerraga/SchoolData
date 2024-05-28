package com.schooldata.restapi.schoolData.Repository;

import com.schooldata.restapi.schoolData.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
