package com.schooldata.restapi.schoolData.Mapper;

import com.schooldata.restapi.schoolData.Entity.Fee;
import com.schooldata.restapi.schoolData.Entity.Teacher;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import com.schooldata.restapi.schoolData.RequestDTO.TeacherRequestDTO;
import com.schooldata.restapi.schoolData.ResposeDTO.TeacherResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    public Teacher teacherMapper(TeacherRequestDTO teacherRequestDTO){
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequestDTO.getFirstName());
        teacher.setLastName(teacherRequestDTO.getLastName());
        teacher.setAddress(teacherRequestDTO.getAddress());
        teacher.setSubject(teacherRequestDTO.getSubject());
        teacher.setStandard(teacherRequestDTO.getStandard());
        return teacher;
    }

    public TeacherResponseDTO teacherResponseMapper(Teacher teacher){
        return new TeacherResponseDTO(
                teacher.getId(),
        teacher.getFirstName(),
        teacher.getLastName(),
        teacher.getAddress(),
        teacher.getSubject(),
        teacher.getStandard());
    }

    public List<TeacherResponseDTO> findAllTeachers(List<Teacher> teachers){
        return teachers.stream().map(this::teacherResponseMapper).collect(Collectors.toList());
    }
}
