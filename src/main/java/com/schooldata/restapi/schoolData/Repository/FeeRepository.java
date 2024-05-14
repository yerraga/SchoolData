package com.schooldata.restapi.schoolData.Repository;

import com.schooldata.restapi.schoolData.Entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository  extends JpaRepository<Fee, Long> {
}
