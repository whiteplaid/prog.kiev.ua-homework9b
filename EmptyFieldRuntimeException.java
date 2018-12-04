package com.homework.groupofstudentsbase;

import java.io.Serializable;

public class EmptyFieldRuntimeException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public EmptyFieldRuntimeException(String message) {
		super();
		this.message = message;
	}

	public EmptyFieldRuntimeException() {
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
		return "EmptyFieldRuntimeException [message=" + message + "]";
	}
	
}
