package com.schooldata.restapi.schoolData.Repository;

import com.schooldata.restapi.schoolData.Entity.Teacher;
import com.schooldata.restapi.schoolData.Enum.Standard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByStandard(Standard standard);
}
