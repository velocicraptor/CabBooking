package com.cg.exception;

public class CustomerAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1970762601225780363L;
	public CustomerAlreadyExistsException(String msg) {
		super(msg);

}
}
