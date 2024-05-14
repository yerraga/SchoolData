package com.schooldata.restapi.schoolData.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import lombok.Data;

@Entity
@Table (name = "Students")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@Data
public class StudentEntity {
	@ Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Admission_Number")
	private Long id;
	@NotNull(message = "First Name cannot be empty")
	@Column (name = "First_Name")
	private String surname;
	@NotNull(message = "Last Name cannot be empty")
	@Column (name = "Last_Name")
	@NotNull(message = "First Name cannot be empty")
	private String name;
	@NotNull(message = "Father Name cannot be empty")
	@Column (name = "Father_Name")
	private String fatherName;
	@NotNull(message = "Mother Name cannot be empty")
	@Column (name = "Mother_Name")
	private String motherName;
	@NotNull(message = "Address cannot be empty")
	@Column (name = "Address")
	private String address;
	@NotNull(message = "Standard cannot be empty")
	@Column(name = "Standard")
	@Enumerated(EnumType.STRING)
	private Standard standard;
	@NotNull(message = "Student type cannot be empty")
	@Column(name = "Student_Type")
	@Enumerated(EnumType.STRING)
	private StudentType studentType;
}
