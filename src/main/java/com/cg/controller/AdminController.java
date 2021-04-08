package com.cg.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.AdminDto;
import com.cg.dto.TripBookingDto;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.TripNotFoundException;
import com.cg.serviceimpl.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImpl adminService;
	
	/*
	 *	Method Name - insertAdmin
	 * 	Parameter List - AdminDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - insert an admin object into the database 
	 */
	@PostMapping
	public ResponseEntity<AdminDto> insertAdmin(@RequestBody AdminDto admin) {
		return new ResponseEntity<AdminDto>(adminService.insertAdmin(admin), HttpStatus.OK);
	}
	
	/*
	 *	Method Name - updateAdmin
	 * 	Parameter List - AdminDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - update an admin object into the database 
	 */
	@PutMapping
	public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto admin) throws AdminNotFoundException {
		return new ResponseEntity<AdminDto>(adminService.updateAdmin(admin), HttpStatus.OK);
	}
	
	/*
	 *	Method Name - deleteAdmin
	 * 	Parameter List - AdminDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - delete an admin object from the database 
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<AdminDto> deleteAdmin(@PathVariable("id") int id) throws AdminNotFoundException {
		return new ResponseEntity<AdminDto>(adminService.deleteAdmin(id), HttpStatus.OK);
	}
	
	/*
	 *	Method Name - getAllTrips
	 * 	Parameter List - TripBookingDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - get the list of all trips from the database 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<List<TripBookingDto>> getAllTrips(@PathVariable("id") int customerId) throws CustomerNotFoundException {
		System.out.println("Hello ADMIN");
		List<TripBookingDto> allTrips = adminService.getAllTrips(customerId);
		return new ResponseEntity<List<TripBookingDto>>(allTrips, HttpStatus.OK) ;
	}
	
	/*
	 *	Method Name - getTripsCabwise
	 * 	Parameter List - TripBookingDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - get the list of trips in cabwise order from the database 
	 */
	@GetMapping("/cab/{cabId}")
	public ResponseEntity<List<TripBookingDto>> getTripsCabwise(@PathVariable ("cabId") int cabId) throws TripNotFoundException {
		List<TripBookingDto> cabwise = adminService.getTripsCabwise(cabId);
		return new ResponseEntity<List<TripBookingDto>>(cabwise, HttpStatus.OK);
	}
	
	/*
	 *	Method Name - getTripsDatewise
	 * 	Parameter List - TripBookingDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - get the list of trips in datewise order from the database 
	 */
	@GetMapping("/date/{date}")
	public ResponseEntity<List<TripBookingDto>> getTripsDatewise(@PathVariable ("date") LocalDateTime fromDate) {
		List<TripBookingDto> datewise = adminService.getTripsDatewise(fromDate);
		return new ResponseEntity<List<TripBookingDto>>(datewise, HttpStatus.OK);
	}
	
	/*
	 *	Method Name - getTripsAllTripsForDays
	 * 	Parameter List - TripBookingDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - get the list of all trips from and to a specified local date time order from the database 
	 */
	@GetMapping("/day{/tripsForDays}") 
	public ResponseEntity<List<TripBookingDto>> getAllTripsForDays(@RequestParam("customerId") int customerId,
			@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
			@RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate) throws CustomerNotFoundException{
		List<TripBookingDto> ad =  adminService.getAllTripsForDays(customerId, fromDate, toDate);
		return new ResponseEntity<List<TripBookingDto>>(ad, HttpStatus.OK);
	}
	
	/*
	 *	Method Name - viewAdmin
	 * 	Parameter List - AdminDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - view the admin object from the database 
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<AdminDto> viewAdmin(@PathVariable("id") int id) throws AdminNotFoundException {
		return new ResponseEntity<AdminDto>(adminService.viewAdmin(id), HttpStatus.OK);
	}

}