package com.schooldata.restapi.schoolData.Entity;

import com.schooldata.restapi.schoolData.Enum.Standard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name  = "Id")
    private Long id;
    @Column(name = "Surname")
    private String firstName;
    @Column(name = "Name")
    private String lastName;
    @Column (name = "Address")
    private String address;
    @Column(name = "Subject")
    private String subject;
    @Column(name = "`Class Teacher`")
    @Enumerated(EnumType.STRING)
    private Standard standard;
}
