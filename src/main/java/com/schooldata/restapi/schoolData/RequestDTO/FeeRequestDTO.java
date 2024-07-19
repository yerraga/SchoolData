package com.schooldata.restapi.schoolData.RequestDTO;

import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeeRequestDTO {

    private Standard standard;

    private StudentType studentType;

    private int schoolFee;

    private int hostelFee;

    private int uniformFee;

    private int busFee;

    private int examinationFee;

    private int tuitionFee;

    private Long daysScholarFee;

    private Long hostlerFee;

    public Long totalDaysScholarFee() {
        return daysScholarFee = (long) (schoolFee + uniformFee + busFee + examinationFee + tuitionFee);
    }

    public Long totalHostlerFee() {
        return hostlerFee = (long) (schoolFee + uniformFee + hostelFee + examinationFee + tuitionFee);
    }
}
