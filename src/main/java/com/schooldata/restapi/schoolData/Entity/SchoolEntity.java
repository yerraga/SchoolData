package com.schooldata.restapi.schoolData.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.schooldata.restapi.schoolData.Class.Classes;
import com.schooldata.restapi.schoolData.Teachers.Teacher;

@Entity
@Table(name = "YGS_Schools")
public class SchoolEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private int id;
	@Column (name = "Class_Data")
	private List<Classes> classes;
	@Column (name = "Teacher_Data")
	private List<Teacher> teachers;

	public SchoolEntity() {

	}

	public SchoolEntity(int id, List<Classes> classes, List<Teacher> teachers) {
		super();
		this.id = id;
		this.classes = classes;
		this.teachers = teachers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "SchoolEntity [id=" + id + ", classes=" + classes + ", teachers=" + teachers + "]";
	}

}
