package com.schooldata.restapi.schoolData.Controller;

import com.schooldata.restapi.schoolData.Entity.ResultsEntity;
import com.schooldata.restapi.schoolData.Exceptions.StudentException;
import com.schooldata.restapi.schoolData.RequestDTO.ResultsRequestDTO;
import com.schooldata.restapi.schoolData.ResposeDTO.ResultsResponseDTO;
import com.schooldata.restapi.schoolData.Service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/results")
public class ResultsController {

    @Autowired
    ResultsService resultsService;


    @GetMapping("/listOfResults")
    public List<ResultsEntity> getALlResults(){
      return resultsService.getALlResults();
    }

    @PostMapping ("/saveResult")
    public ResultsResponseDTO saveResult (@RequestBody ResultsRequestDTO resultsRequestDTO) throws StudentException {
        return resultsService.saveResult(resultsRequestDTO);
    }
}
