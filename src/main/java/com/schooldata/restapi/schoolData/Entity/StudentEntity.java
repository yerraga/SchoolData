package com.schooldata.restapi.schoolData.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Students")
public class StudentEntity {
	@ Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Admission_Number")
	private Long id;
	@Column (name = "Family_Name")
	private String surname;
	@Column (name = "Name")
	private String name;
	@Column (name = "Father_Name")
	private String fatherName;
	@Column (name = "Mother_Name")
	private String motherName;
	
	public StudentEntity() {
		
	}
	public StudentEntity(String surname, String name, String fatherName, String motherName) {
		super();
		this.surname = surname;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", surname=" + surname + ", name=" + name + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + "]";
	}
	
}
