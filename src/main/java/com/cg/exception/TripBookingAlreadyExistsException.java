package com.cg.exception;

public class TripBookingAlreadyExistsException  extends Exception {

	private static final long serialVersionUID = 914569459626622748L;

	public TripBookingAlreadyExistsException(String msg) {
		super(msg);
	} 

}
