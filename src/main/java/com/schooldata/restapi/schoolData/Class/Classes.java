package com.schooldata.restapi.schoolData.Class;

public class Classes {
	private String class_Name;

	public Classes() {

	}

	public Classes(String class_Name) {
		super();
		this.class_Name = class_Name;
	}

	public String getClass_Name() {
		return class_Name;
	}

	public void setClass_Name(String class_Name) {
		this.class_Name = class_Name;
	}

	@Override
	public String toString() {
		return "Classes [class_Name=" + class_Name + "]";
	}
}
