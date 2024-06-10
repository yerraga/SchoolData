package com.schooldata.restapi.schoolData.Repository;

import com.schooldata.restapi.schoolData.Entity.ResultsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends JpaRepository<ResultsEntity, Long> {
    ResultsEntity findByStudentId(Long studentId);
}
