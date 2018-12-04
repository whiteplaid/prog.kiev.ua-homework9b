package com.homework.groupofstudentsbase;

public class NameRuntimeException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	public NameRuntimeException(String message) {
		super();
		this.message = message;
	}
	public NameRuntimeException() {
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
		return "NameRuntimeException [message=" + message + "]";
	}
	

}
