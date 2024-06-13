package com.schooldata.restapi.schoolData.Service;

import com.schooldata.restapi.schoolData.Entity.ResultsEntity;
import com.schooldata.restapi.schoolData.Entity.StudentEntity;
import com.schooldata.restapi.schoolData.Enum.Examinations;
import com.schooldata.restapi.schoolData.Enum.PassedOrFailed;
import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Exceptions.StudentException;
import com.schooldata.restapi.schoolData.Mapper.ResultsMapper;
import com.schooldata.restapi.schoolData.Repository.ResultsRepository;
import com.schooldata.restapi.schoolData.Repository.StudentRepository;
import com.schooldata.restapi.schoolData.RequestDTO.ResultsRequestDTO;
import com.schooldata.restapi.schoolData.ResposeDTO.ResultsResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultsService {

    @Autowired
    ResultsRepository resultsRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ResultsMapper resultsMapper;

    public List<ResultsEntity> getALlResults(){
       return resultsRepository.findAll();
    }

    public ResultsEntity getResultsByStudentId(Long studentId){
        return resultsRepository.findByStudentId(studentId);
    }

    public ResultsResponseDTO saveResult(ResultsRequestDTO resultsRequestDTO) throws StudentException {
        resultsRequestDTO.setStandard(getStudentStandard(resultsRequestDTO.getStudentId()));
        resultsRequestDTO.setStudentName(getStudentFullName(resultsRequestDTO.getStudentId()));
        resultsRequestDTO.setScienceMarks(isStandardBelowEigth(resultsRequestDTO.getStandard())? 0: resultsRequestDTO.getScienceMarks());
        resultsRequestDTO.setPhysicsAndChemistryMarks(!isStandardBelowEigth(resultsRequestDTO.getStandard()) ? 0 : resultsRequestDTO.getPhysicsAndChemistryMarks());
        resultsRequestDTO.setTotalMarks(getTotalMarksOfStudent(resultsRequestDTO));
        resultsRequestDTO.setPassedOrFailed(getPassesOrFailedInExamination(resultsRequestDTO));
        ResultsEntity resultsEntity = resultsMapper.mapResultsRequestToEntity(resultsRequestDTO);
        ResultsEntity saveResultsEntity = resultsRepository.save(resultsEntity);
        return resultsMapper.mapResultsToResponse(saveResultsEntity);
    }

    public PassedOrFailed getPassesOrFailedInExamination(ResultsRequestDTO resultsRequestDTO) {
        if (resultsRequestDTO.getExamination() == Examinations.UNITTEST_I || resultsRequestDTO.getExamination() == Examinations.UNITTEST_II ||
                resultsRequestDTO.getExamination() == Examinations.UNITTEST_III || resultsRequestDTO.getExamination() == Examinations.UNITTEST_IV) {
            if (resultsRequestDTO.getStandard() != Standard.TEN && resultsRequestDTO.getStandard() != Standard.NINE && resultsRequestDTO.getStandard() != Standard.EIGHT) {
                return (resultsRequestDTO.getTeluguMarks() < 15 || resultsRequestDTO.getHindiMarks() < 15 ||
                        resultsRequestDTO.getEnglishMarks() < 15 || resultsRequestDTO.getMathematicsMarks() < 15 ||
                        resultsRequestDTO.getScienceMarks() < 15 || resultsRequestDTO.getSocialMarks() < 15) ? PassedOrFailed.F : PassedOrFailed.P;
            }
            else {
                return (resultsRequestDTO.getTeluguMarks() < 15 || resultsRequestDTO.getHindiMarks() < 15 ||
                        resultsRequestDTO.getEnglishMarks() < 15 || resultsRequestDTO.getMathematicsMarks() < 15 ||
                        resultsRequestDTO.getPhysicsAndChemistryMarks() < 15 || resultsRequestDTO.getSocialMarks() < 15) ? PassedOrFailed.F : PassedOrFailed.P;
            }
        }else if (resultsRequestDTO.getExamination() == Examinations.QUATERLY_EXAMINATIONS || resultsRequestDTO.getExamination() == Examinations.HALF_YEARLY_EXAMINATIONS ||
                resultsRequestDTO.getExamination() == Examinations.ANUAL_EXAMINATIONS) {
            if (resultsRequestDTO.getStandard() != Standard.TEN && resultsRequestDTO.getStandard() != Standard.NINE && resultsRequestDTO.getStandard() != Standard.EIGHT) {
                return (resultsRequestDTO.getTeluguMarks() < 50 || resultsRequestDTO.getHindiMarks() < 50 ||
                        resultsRequestDTO.getEnglishMarks() < 50 || resultsRequestDTO.getMathematicsMarks() < 15 ||
                        resultsRequestDTO.getScienceMarks() < 50 || resultsRequestDTO.getSocialMarks() < 50) ? PassedOrFailed.F : PassedOrFailed.P;
            } else {
                return (resultsRequestDTO.getTeluguMarks() < 50 || resultsRequestDTO.getHindiMarks() < 50 ||
                        resultsRequestDTO.getEnglishMarks() < 50 || resultsRequestDTO.getMathematicsMarks() < 15 ||
                        resultsRequestDTO.getPhysicsAndChemistryMarks() < 50 || resultsRequestDTO.getSocialMarks() < 50) ? PassedOrFailed.F : PassedOrFailed.P;
            }
        }
        return null;
    }

    public Standard getStudentStandard( Long studentId) throws StudentException {
        Optional<StudentEntity> getStudent = studentRepository.findById(studentId);
        if(getStudent.isEmpty()){
            throw  new StudentException(HttpStatus.NOT_FOUND, "Student not found with id ");
        }
        return  getStudent.get().getStandard();
    }

    public String getStudentFullName( Long studentId) throws StudentException {
        Optional<StudentEntity> getStudent = studentRepository.findById(studentId);
        if(getStudent.isEmpty()){
            throw  new StudentException(HttpStatus.NOT_FOUND, "Student not found with id ");
        }
        return getStudent.get().getSurname().concat(" ").concat(getStudent.get().getName());
    }

    public double getTotalMarksOfStudent(ResultsRequestDTO resultsRequestDTO){
        return  resultsRequestDTO.getTeluguMarks()+ resultsRequestDTO.getHindiMarks()+
                resultsRequestDTO.getEnglishMarks()+resultsRequestDTO.getMathematicsMarks()+
                resultsRequestDTO.getScienceMarks()+resultsRequestDTO.getSocialMarks()+resultsRequestDTO.getPhysicsAndChemistryMarks();
    }

    public boolean isStandardBelowEigth(Standard standard){
        return standard == Standard.EIGHT || standard == Standard.NINE || standard == Standard.TEN;
    }
}
