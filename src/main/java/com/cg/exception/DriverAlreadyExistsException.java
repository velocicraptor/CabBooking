package com.cg.exception;



public class DriverAlreadyExistsException extends RuntimeException {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	
	public DriverAlreadyExistsException(String message) {
		super(message);
	}
}
