package com.schooldata.restapi.schoolData.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "Students")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class StudentEntity {
	@ Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Admission_Number")
	private Long id;
	@Column (name = "First_Name")
	private String surname;
	@Column (name = "Last_Name")
	private String name;
	@Column (name = "Father_Name")
	private String fatherName;
	@Column (name = "Mother_Name")
	private String motherName;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;

	private Long pincode;


	
	
}
