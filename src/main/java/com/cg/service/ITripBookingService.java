package com.cg.service;

import java.util.List;

import com.cg.dto.TripBookingDto;
import com.cg.entities.TripBooking;

public interface ITripBookingService {

	public TripBookingDto insertTripBooking(TripBookingDto tripBooking) ;
	public TripBookingDto updateTripBooking(TripBookingDto tripBooking) ;
	public TripBookingDto deleteTripBooking(TripBookingDto tripBooking);
	public List<TripBooking> getAllTripsByCustomer(int customerId);
	TripBooking calculateBill(TripBooking tripbooking);
	public double calculateBill(int customerId);
}
