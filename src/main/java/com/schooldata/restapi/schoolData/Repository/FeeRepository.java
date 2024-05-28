package com.schooldata.restapi.schoolData.Repository;

import com.schooldata.restapi.schoolData.Entity.Fee;
import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRepository  extends JpaRepository<Fee, Long> {

    List<Fee> getFeeByStandard(Standard standard);

    Fee getFeeByStandardAndStudentType(Standard standard, StudentType studentType);
}
