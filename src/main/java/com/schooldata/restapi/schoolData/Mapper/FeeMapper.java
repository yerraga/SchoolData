package com.schooldata.restapi.schoolData.Mapper;

import com.schooldata.restapi.schoolData.Entity.Fee;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import com.schooldata.restapi.schoolData.RequestDTO.FeeRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class FeeMapper {

    public Fee mapFee(FeeRequestDTO feeRequestDTO){
        Fee fee = new Fee();
        fee.setStandard(feeRequestDTO.getStandard());
        fee.setStudentType(feeRequestDTO.getStudentType());
        fee.setSchoolFee(feeRequestDTO.getSchoolFee());
        fee.setHostelFee(feeRequestDTO.getStudentType().equals(StudentType.DAYS_SCHOLAR) ? 0 :  feeRequestDTO.getHostelFee());
        fee.setUniformFee(feeRequestDTO.getUniformFee());
        fee.setBusFee( feeRequestDTO.getStudentType().equals(StudentType.HOSTLER) ? 0 :   feeRequestDTO.getBusFee());
        fee.setExaminationFee(feeRequestDTO.getExaminationFee());
        fee.setTuitionFee(feeRequestDTO.getTuitionFee());
        fee.setDaysScholarFee(feeRequestDTO.totalDaysScholarFee());
        fee.setHostlerFee(feeRequestDTO.totalHostlerFee());
        return fee;
    }
}
