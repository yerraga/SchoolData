package com.schooldata.restapi.schoolData.Service;

import com.schooldata.restapi.schoolData.Entity.ResultsEntity;
import com.schooldata.restapi.schoolData.Repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsService {

    @Autowired
    ResultsRepository resultsRepository;

    public List<ResultsEntity> getALlResults(){
       return resultsRepository.findAll();
    }

    public ResultsEntity getResultsByStudentId(Long studentId){
        return resultsRepository.findByStudentId(studentId);
    }

    public ResultsEntity saveResult(ResultsEntity resultsEntity){

        return null;
    }
}
