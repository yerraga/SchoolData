package com.schooldata.restapi.schoolData.Service;

import com.schooldata.restapi.schoolData.Entity.Teacher;
import com.schooldata.restapi.schoolData.Mapper.TeacherMapper;
import com.schooldata.restapi.schoolData.Repository.TeacherRepository;
import com.schooldata.restapi.schoolData.RequestDTO.TeacherRequestDTO;
import com.schooldata.restapi.schoolData.ResposeDTO.TeacherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    TeacherMapper teacherMapper;


    public List<TeacherResponseDTO> getALlTeachers(){
        List<Teacher> teachers  = teacherRepository.findAll();
        return teacherMapper.findAllTeachers(teachers);
    }

    public TeacherResponseDTO saveTeacher(TeacherRequestDTO teacherRequestDTO){
         Teacher teacher = teacherMapper.teacherMapper(teacherRequestDTO);
        teacherRepository.save(teacher);
        return teacherMapper.teacherResponseMapper(teacher);
    }



}
