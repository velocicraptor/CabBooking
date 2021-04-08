package com.cg.controller;

import java.util.List;

//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CabDto;
import com.cg.exception.CabAlreadyExistsException;
import com.cg.exception.CabNotFoundException;
import com.cg.serviceimpl.CabServiceImpl;



@RestController
@RequestMapping(value = "/cabs")
public class CabController {

	@Autowired
	CabServiceImpl cabService;
	/*
	 * Method Name 		- addNewCab
	 * Parameter List 	- CabDto object
	 * Return Type		- ResponseEntity object
	 * Description		- insert the CabDto object into database by calling the insertCab method from cabServiceImpl object
	 */
	@PostMapping(value="/add")
	public ResponseEntity<Object> addNewCab(@RequestBody CabDto cab) throws CabAlreadyExistsException {

		CabDto cabDto = cabService.insertCab(cab);
		return ResponseEntity.ok(cabDto);
	}

	/*
	 * Method Name 		- updateCab
	 * Parameter List 	- CabDto object
	 * Return Type		- ResponseEntity object
	 * Description		- update the existing CabDto object in database by calling the updateCab method from cabServiceImpl object
	 */
	@PutMapping(value="/update")
	public ResponseEntity<Object> updateCab(@RequestBody CabDto cab) throws CabAlreadyExistsException {
		CabDto cabDto = cabService.updateCab(cab);
		return ResponseEntity.ok(cabDto);
	}

	/*
	 * Method Name 		- deleteCab
	 * Parameter List 	- CabDto object
	 * Return Type		- ResponseEntity object
	 * Description		- delete the CabDto object from the database if it exists
	 */
	@DeleteMapping(value="/delete")
	public ResponseEntity<Object> deleteCab(@RequestBody CabDto cab) throws CabNotFoundException {
		CabDto cabDto = cabService.deleteCab(cab);
		return ResponseEntity.ok(cabDto);
	}

	/*
	 * Method Name 		- getCabById
	 * Parameter List 	- int id(cabId)
	 * Return Type		- CabDto object
	 * Description		- This method retrieves the CabDto object from database and return it 
	 */
	@GetMapping(value="/getcab/{id}")
	public CabDto getCabById(@PathVariable int id) throws CabNotFoundException {
		System.out.println("Testing something");
		return cabService.findCabById(id);

	}

	/*
	 * Method Name 		- countCabOfType
	 * Parameter List 	- String carType
	 * Return Type		- int 
	 * Description		- This method returns the count of cabs of type carType from the database
	 */
	@GetMapping(value="/count/{carType}")
	public int counCabOfCarType(@PathVariable String carType) {

		return cabService.countCabsOfType(carType);

	}

	/*
	 * Method Name 		- viewAllCabsOfType
	 * Parameter List 	- String carType
	 * Return Type		- List<CabDto>
	 * Description		- This method returns the List of cabs which are of type carType from the database
	 */
	@GetMapping(value="/cabtype/{carType}")
	public List<CabDto> viewAllCabsOfType(@PathVariable String carType) throws CabNotFoundException {

		return (cabService.viewCabsOfType(carType));

	}

	/*
	 * Method Name 		- viewAllCabsToBooked
	 * Parameter List 	- None
	 * Return Type		- List<CabDto>
	 * Description		- This method returns the List of availableCabs from database where booked = false
	 */
	@GetMapping(value="/allcabs/availableCabs")
	public List<CabDto> viewAllCabsToBeBooked() throws CabNotFoundException {

		return (cabService.viewCabToBeBooked());

	}

}