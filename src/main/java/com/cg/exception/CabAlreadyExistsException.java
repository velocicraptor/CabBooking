package com.cg.exception;

public class CabAlreadyExistsException extends RuntimeException{
	
	
	
	
	private static final long serialVersionUID = 1L;

	public CabAlreadyExistsException() {

	}
	

	public CabAlreadyExistsException(String message) {
		super(message);
	}

}
