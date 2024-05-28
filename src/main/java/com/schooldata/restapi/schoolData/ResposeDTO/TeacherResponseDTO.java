package com.schooldata.restapi.schoolData.ResposeDTO;

import com.schooldata.restapi.schoolData.Enum.Standard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseDTO {

    private Long id;
    private String firstName;

    private String lastName;

    private String address;

    private String subject;

    private Standard standard;

}
