package com.schooldata.restapi.schoolData.RequestDTO;

import com.schooldata.restapi.schoolData.Entity.StudentEntity;
import com.schooldata.restapi.schoolData.Enum.Examinations;
import com.schooldata.restapi.schoolData.Enum.PassedOrFailed;
import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Exceptions.StudentException;
import com.schooldata.restapi.schoolData.Repository.StudentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
public class ResultsRequestDTO {



    private Long studentId;

    private Standard standard;

    private String academicYear;


    private String studentName;


    private Examinations examination;


    private double teluguMarks;


    private double hindiMarks;


    private double englishMarks;


    private double mathematicsMarks;


    private double scienceMarks;


    private double physicsAndChemistryMarks;


    private double socialMarks;


    private double totalMarks;

    private PassedOrFailed passedOrFailed;


}
