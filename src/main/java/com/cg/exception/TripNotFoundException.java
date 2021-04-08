package com.cg.exception;

public class TripNotFoundException extends Exception {

	private static final long serialVersionUID = 914569459626622748L;

	public TripNotFoundException(String msg) {
		super(msg);
	}
}
