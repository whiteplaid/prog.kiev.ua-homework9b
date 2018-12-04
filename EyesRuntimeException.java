package com.homework.groupofstudentsbase;

import java.io.Serializable;

public class EyesRuntimeException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public EyesRuntimeException(String message) {
		super();
		this.message = message;
	}

	public EyesRuntimeException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EyesRuntimeException [message=" + message + "]";
	}
	

}
