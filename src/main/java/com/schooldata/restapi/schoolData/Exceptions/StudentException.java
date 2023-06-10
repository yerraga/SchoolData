package com.schooldata.restapi.schoolData.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StudentException extends Exception {

	public static String notFountException() {
		return "Student not found with ID";
		
	}
}
