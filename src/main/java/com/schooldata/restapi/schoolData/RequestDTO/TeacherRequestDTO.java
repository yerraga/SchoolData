package com.schooldata.restapi.schoolData.RequestDTO;

import com.schooldata.restapi.schoolData.Enum.Standard;
import lombok.Data;

@Data
public class TeacherRequestDTO {

    private String firstName;

    private String lastName;

    private String address;

    private String subject;

    private Standard standard;
}
