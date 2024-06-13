package com.schooldata.restapi.schoolData.ResposeDTO;

import com.schooldata.restapi.schoolData.Enum.Examinations;
import com.schooldata.restapi.schoolData.Enum.PassedOrFailed;
import com.schooldata.restapi.schoolData.Enum.Standard;
import lombok.Data;

@Data
public class ResultsResponseDTO {

    private Long id;

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
