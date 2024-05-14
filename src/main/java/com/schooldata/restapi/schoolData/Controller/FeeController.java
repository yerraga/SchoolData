package com.schooldata.restapi.schoolData.Controller;

import com.schooldata.restapi.schoolData.Entity.Fee;
import com.schooldata.restapi.schoolData.RequestDTO.FeeRequestDTO;
import com.schooldata.restapi.schoolData.Service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/V1/fee")
public class FeeController {

    @Autowired
    FeeService  feeService;

    @PostMapping("/saveFee")
    public Fee saveFee(@RequestBody FeeRequestDTO feeRequestDTO){
        return feeService.saveFee(feeRequestDTO);
    }
}
