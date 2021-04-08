package com.cg.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Convertor;
import com.cg.dto.TripBookingDto;
import com.cg.entities.TripBooking;
import com.cg.exception.TripNotFoundException;
import com.cg.repository.TripBookingRepository;

@Service
public class TripBookingServiceImpl {
	@Autowired
	TripBookingRepository repo;

	/*
	 * Method Name -insertTripBooking, Parameter List - tripbookingDto object,
	 * Return type - Convertor object, Description - insert a trip booking object
	 * into the database
	 */
	public TripBookingDto insertTripBooking(TripBookingDto tbdto) {
		TripBooking tb = Convertor.convertTripBookingDTOtoEntity(tbdto);
		TripBooking tbsaved = repo.save(tb);
		return Convertor.convertTripBookingEntitytoDTO(tbsaved);
	}
	
	/*
	 * Method Name - updateTripBooking, Parameter List - tripbookingDto object,
	 * Return type - Convertor object, Description - update a trip booking object
	 * into the database
	 */
		public TripBookingDto updateTripBooking(TripBookingDto tbdto){
			TripBooking tb= Convertor.convertTripBookingDTOtoEntity(tbdto);
			TripBooking tbsaved = repo.save(tb);
			return Convertor.convertTripBookingEntitytoDTO(tbsaved);

	}
		
		/*
		 * Method Name - deleteTripBooking, Parameter List - tripbookingDto object,
		 * Return type - Convertor object, Description - delete a trip booking object
		 * into the database
		 */
		public TripBookingDto deleteTripBooking(int id) throws TripNotFoundException {
			Optional<TripBooking> tripOpt = repo.findById(id);
			TripBooking tripbooking = tripOpt.get();
			if(tripOpt.isPresent()) 
			{
				repo.delete(tripbooking);
				return Convertor.convertTripBookingEntitytoDTO(tripbooking);
			}else {
				throw new TripNotFoundException("Booking not found");
			}

		}
		
		/*
		 * Method Name - getAllTripsCustomer, Parameter List - customer Id, Return type
		 * - ResponseEntity object, Description - view the trips of particular customer
		 * provided the customer id.
		 */
       public List<TripBooking> getAllTripsCustomer(int customerId) throws TripNotFoundException {
			List<TripBooking> trips = repo.getAllTripsByCustomer(customerId);
			if (trips.isEmpty()) {
				throw new TripNotFoundException("Trip booking not found");
			} else {
				return  trips;
			}
		}
       
       /*
   	 * Method Name - calculateBill, Parameter List - tripbooking object, Return type
   	 * - tripbooking object, Description - calculate the bill .
   	 */
       public TripBooking calculateBill(TripBooking tripbooking){
   		float bill = tripbooking.getDistanceInKm() * tripbooking.getDriver().getCab().getPerKmRate();
   		tripbooking.setBill(bill);
   	    return tripbooking;
   	}
}
