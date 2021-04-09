package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dto.TripBookingDto;
import com.cg.entities.TripBooking;
import com.cg.service.ITripBookingService;

@RestController
@RequestMapping("/tripbooking")
public class TripBookingController {
	@Autowired
	ITripBookingService service;
	 

	/*
	 * Method Name - insertTripBooking, Parameter List - tripbookingDto object,
	 * Return type - ResponseEntity, object Description - insert a trip booking
	 * object into the database
	 */	
	@PostMapping
		public ResponseEntity<TripBookingDto> insertTripBooking(@RequestBody TripBookingDto tbdto) {
		return new ResponseEntity<TripBookingDto>(service.insertTripBooking(tbdto), HttpStatus.OK);
	}
	
	/*
	 * Method Name - updateTripBooking, Parameter List - tripbookingDto object,
	 * Return type - ResponseEntity, object Description - update a trip booking
	 * object into the database
	 */
	  @PutMapping
		public ResponseEntity<TripBookingDto> updateTripBooking(@RequestBody TripBookingDto tbdto) {
			return new ResponseEntity<TripBookingDto>(service.updateTripBooking(tbdto),HttpStatus.OK);
	  }
	  
	  /*
		 * Method Name - deleteTripBooking, Parameter List - tripbookingDto object,
		 * Return type - ResponseEntity, object Description - delete a trip booking
		 * object into the database
		 */
	     @DeleteMapping("/{id}")
	 	public ResponseEntity<TripBookingDto> deleteTripBooking(@PathVariable("id") TripBookingDto customerId){
	 		return new ResponseEntity<TripBookingDto>(service.deleteTripBooking(customerId),HttpStatus.OK);
	     }
	     
	        /*
	 	 * Method Name - viewAllTripsCustomer, Parameter List - customer Id, Return type
	 	 * - ResponseEntity, object Description - view the trips of particular customer
	        */
	     @GetMapping("/{customerId}")
	 	public ResponseEntity<Object>  getAllTripsCustomer(@PathVariable ("customerId") int customerId) {
	 		List<TripBooking> bookingList;
	 		try {
	 			bookingList = service.getAllTripsCustomer(customerId);
	 			return new ResponseEntity<Object>(bookingList, HttpStatus.OK);
	 		} catch (Exception e) {
	 	
	 			e.printStackTrace();
	 		}
	 		return new ResponseEntity<Object>("No Bookings found in DataBase with given ID", HttpStatus.UNAUTHORIZED);
	 	}

	                /*
		 	 * Method Name - calculateBill, Parameter List - customer Id, Return type
		 	 * - ResponseEntity, object Description - calculate of a particular customer
		 	 */
	     
	     @GetMapping("/bill/{customerId}")
	 	public ResponseEntity<Object>calculateBill(@PathVariable("customerId") int customerId) {
	 		Double bookingData;
	 		try {
	 			bookingData = service.calculateBill(customerId);
	 			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
	 		} catch (Exception e) {
	 			// TODO: handle exception
	 			e.printStackTrace();

	 		}
	 		return new ResponseEntity<Object>("No Bookings found in DataBase with given ID", HttpStatus.UNAUTHORIZED);

	 	}
	     
}
