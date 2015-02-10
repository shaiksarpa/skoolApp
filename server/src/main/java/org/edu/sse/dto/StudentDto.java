package org.edu.sse.dto;

import org.edu.sse.model.Student;

public class StudentDto extends Student {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4740345742179100494L;

	private String message;

	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
