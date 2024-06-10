package com.schooldata.restapi.schoolData.Controller;

import com.schooldata.restapi.schoolData.Entity.ResultsEntity;
import com.schooldata.restapi.schoolData.Service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
