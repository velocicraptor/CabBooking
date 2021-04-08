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

import com.cg.dto.DriverDto;
import com.cg.exception.DriverAlreadyExistsException;
import com.cg.exception.DriverNotFoundException;
import com.cg.serviceimpl.DriverServiceImpl;
@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	DriverServiceImpl driverService;
	
	/*
	 *	Method Name - insertDriver
	 * 	Parameter List - DriverDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - To insert a driver object into the database 
	 */
	@PostMapping 
	public ResponseEntity<DriverDto> insertDriver(@RequestBody DriverDto driverdto)throws DriverAlreadyExistsException   {
	return new ResponseEntity<DriverDto>(driverService.insertDriver(driverdto),HttpStatus.OK);
	
	}
	
	/*
	 *	Method Name - updateDriver
	 * 	Parameter List - DriverDto object
	 *	Return Type - ResponseEntity object 
	 *	Description - To update a driver object in the database 
	 */
	@PutMapping("/drivers")
	public ResponseEntity<DriverDto> updateDriver(@RequestBody DriverDto driver) throws DriverNotFoundException {
		return new ResponseEntity<DriverDto>(driverService.updateDriver(driver),HttpStatus.OK);
	}
	
	/*
	 *	Method Name - viewDriver
	 * 	Parameter List - int id (id of the driver)
	 *	Return Type - ResponseEntity object 
	 *	Description - To view a driver object from the database using the driver id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<DriverDto> viewDriver(@PathVariable("/id") int id) throws DriverNotFoundException {
		return new ResponseEntity<DriverDto>(driverService.viewDriver(id),HttpStatus.OK);
	}
	
	/*
	 *	Method Name - deleteDriver
	 * 	Parameter List - int id (id of the driver)
	 *	Return Type - ResponseEntity object 
	 *	Description - To delete a driver object from the database using the driver id
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<DriverDto> deleteDriver(@PathVariable("/id") int id) throws DriverNotFoundException {
		
		return new ResponseEntity<DriverDto>(driverService.deleteDriver(id),HttpStatus.OK);
	}
	
	/*
	 *	Method Name - viewBestDrivers
	 * 	Parameter List - None
	 *	Return Type - List of DriverDto objects 
	 *	Description - To view list of drivers from the database who has rating greater than or equal to 4.5
	 */
	@GetMapping  ("/drivers/{bestDrivers}")
	public ResponseEntity<List<DriverDto>>viewBestDrivers() throws DriverNotFoundException {
		return  new ResponseEntity<List<DriverDto>>(driverService.viewBestDrivers(),HttpStatus.OK);
	}
	
	
		
}