package com.schooldata.restapi.schoolData.Mapper;

import com.schooldata.restapi.schoolData.Entity.ResultsEntity;
import com.schooldata.restapi.schoolData.RequestDTO.ResultsRequestDTO;
import com.schooldata.restapi.schoolData.ResposeDTO.ResultsResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ResultsMapper {

    public ResultsEntity mapResultsRequestToEntity(ResultsRequestDTO resultsRequestDTO) {
        ResultsEntity results = new ResultsEntity();
        results.setStudentId(resultsRequestDTO.getStudentId());
        results.setStandard(resultsRequestDTO.getStandard());
        results.setAcademicYear(resultsRequestDTO.getAcademicYear());
        results.setStudentName(resultsRequestDTO.getStudentName());
        results.setExamination(resultsRequestDTO.getExamination());
        results.setTeluguMarks(resultsRequestDTO.getTeluguMarks());
        results.setHindiMarks(resultsRequestDTO.getHindiMarks());
        results.setEnglishMarks(resultsRequestDTO.getEnglishMarks());
        results.setMathematicsMarks(resultsRequestDTO.getMathematicsMarks());
        results.setScienceMarks(resultsRequestDTO.getScienceMarks());
        results.setPhysicsAndChemistryMarks(resultsRequestDTO.getPhysicsAndChemistryMarks());
        results.setSocialMarks(resultsRequestDTO.getSocialMarks());
        results.setTotalMarks(resultsRequestDTO.getTotalMarks());
        results.setPassedOrFailed(resultsRequestDTO.getPassedOrFailed());
        return results;
    }

    public ResultsResponseDTO mapResultsToResponse(ResultsEntity resultsEntity)  {
        ResultsResponseDTO resultsResponseDTO = new ResultsResponseDTO();
        resultsResponseDTO.setId(resultsEntity.getId());
        resultsResponseDTO.setStudentId(resultsEntity.getStudentId());
        resultsResponseDTO.setStandard(resultsEntity.getStandard());
        resultsResponseDTO.setAcademicYear(resultsEntity.getAcademicYear());
        resultsResponseDTO.setStudentName(resultsEntity.getStudentName());
        resultsResponseDTO.setExamination(resultsEntity.getExamination());
        resultsResponseDTO.setTeluguMarks(resultsEntity.getTeluguMarks());
        resultsResponseDTO.setHindiMarks(resultsEntity.getHindiMarks());
        resultsResponseDTO.setEnglishMarks(resultsEntity.getEnglishMarks());
        resultsResponseDTO.setMathematicsMarks(resultsEntity.getMathematicsMarks());
        resultsResponseDTO.setScienceMarks(resultsEntity.getScienceMarks());
        resultsResponseDTO.setPhysicsAndChemistryMarks(resultsEntity.getPhysicsAndChemistryMarks());
        resultsResponseDTO.setSocialMarks(resultsEntity.getSocialMarks());
        resultsResponseDTO.setTotalMarks(resultsEntity.getTotalMarks());
        resultsResponseDTO.setPassedOrFailed(resultsEntity.getPassedOrFailed());
        return resultsResponseDTO;
    }


}
