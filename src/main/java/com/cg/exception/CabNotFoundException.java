package com.cg.exception;

public class CabNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9090587718141879101L;
	
	public CabNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}
	
	public CabNotFoundException(String message) {
		super(message);
	}

}
