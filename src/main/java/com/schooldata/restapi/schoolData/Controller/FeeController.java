package com.schooldata.restapi.schoolData.Controller;

import com.schooldata.restapi.schoolData.Entity.Fee;
import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import com.schooldata.restapi.schoolData.RequestDTO.FeeRequestDTO;
import com.schooldata.restapi.schoolData.Service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/fee")
public class FeeController {

    @Autowired
    FeeService  feeService;

    @PostMapping("/saveFee")
    public Fee saveFee(@RequestBody FeeRequestDTO feeRequestDTO){
        return feeService.saveFee(feeRequestDTO);
    }

    @GetMapping("/getFeeList")
    public List<Fee> getFeeList(){
        return feeService.getFeeList();
    }

    @GetMapping("/getFeeByStandard")
    public List <Fee> getFeeByStandard(@RequestParam ("standard") Standard standard){
        return feeService.getFeeByStandard(standard);
    }

    @GetMapping("/getFeeByStandardAndStudentType")
    public  Fee getFeeByStandardAndStudentType(@RequestParam ("standard") Standard standard, @RequestParam ("studentType")StudentType studentType){
        return feeService.getFeeByStandardAndStudentType(standard, studentType);
    }
}
