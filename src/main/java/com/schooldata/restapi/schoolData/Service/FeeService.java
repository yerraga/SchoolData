package com.schooldata.restapi.schoolData.Service;
import com.schooldata.restapi.schoolData.Entity.Fee;
import com.schooldata.restapi.schoolData.Mapper.FeeMapper;
import com.schooldata.restapi.schoolData.Repository.FeeRepository;
import com.schooldata.restapi.schoolData.RequestDTO.FeeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
