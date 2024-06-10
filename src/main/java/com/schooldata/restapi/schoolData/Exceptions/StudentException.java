package com.schooldata.restapi.schoolData.Exceptions;

import org.springframework.http.HttpStatus;

public class StudentException extends Exception {

	private String statusCode;
	private String detailedMessage;
	private HttpStatus httpStatus;

	public StudentException(String code, String message, String detailedMessage) {
		super(message);
		this.statusCode = code;
		this.detailedMessage = detailedMessage;
	}

	public StudentException(HttpStatus httpStatus, String message, String detailedMessage) {
		super(message);
		this.httpStatus = httpStatus;
		this.detailedMessage = detailedMessage;
	}
	public StudentException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public StudentException(String message) {
		super(message);
	}

	public String getDetailedMessage() {
		return detailedMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
