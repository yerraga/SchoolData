package com.schooldata.restapi.schoolData.Service;
import com.schooldata.restapi.schoolData.Entity.Fee;
import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import com.schooldata.restapi.schoolData.Mapper.FeeMapper;
import com.schooldata.restapi.schoolData.Repository.FeeRepository;
import com.schooldata.restapi.schoolData.RequestDTO.FeeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private FeeMapper feeMapper;

    public Fee saveFee(FeeRequestDTO feeRequestDTO){
        Fee fee = feeMapper.mapFee(feeRequestDTO);
        feeRepository.save(fee);
        return fee;
    }


    public List<Fee> getFeeList() {
        return feeRepository.findAll();
    }

    public List <Fee> getFeeByStandard(Standard standard) {
        return feeRepository.getFeeByStandard(standard);
    }

    public Fee getFeeByStandardAndStudentType(Standard standard, StudentType studentType) {
        return feeRepository.getFeeByStandardAndStudentType(standard, studentType);
    }
}
