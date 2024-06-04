package com.schooldata.restapi.schoolData.Controller;

import com.schooldata.restapi.schoolData.Entity.Teacher;
import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.RequestDTO.TeacherRequestDTO;
import com.schooldata.restapi.schoolData.ResposeDTO.TeacherResponseDTO;
import com.schooldata.restapi.schoolData.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/teacher")
public class TeachersCotroller {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/allTeachers")
    public List<TeacherResponseDTO> getAllTeachers(){
        return teacherService.getALlTeachers();
    }

    @PostMapping("/saveTeacher")
    public TeacherResponseDTO saveTeacher(@RequestBody TeacherRequestDTO teacherRequestDTO){
        return teacherService.saveTeacher(teacherRequestDTO);
    }

    @GetMapping("/getClassTeacherBasedOnStandard")
    public TeacherResponseDTO getClassTeacherBasedOnStandard(@RequestParam(name = "standard")Standard standard){
        return teacherService.getClassTeacherBasedOnStandard(standard);
    }
}
