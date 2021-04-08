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
import com.cg.serviceimpl.CustomerServiceImpl;
import com.cg.dto.CustomerDto;
import com.cg.exception.CustomerAlreadyExistsException;
import com.cg.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerService;

	/*
	*    Method Name - saveCustomer
	*    Parameter List - CustomerDto Object
	*    Return Type - ResponseEntity Object
	*    Description - Insert a customer object to the database 
	*/
	@PostMapping
	public ResponseEntity<CustomerDto> insertCustomer(@RequestBody CustomerDto customerdto) throws  CustomerAlreadyExistsException{
		
			return new ResponseEntity<CustomerDto>(customerService.insertCustomer(customerdto),HttpStatus.OK);	
	}
	
	/*
	*    Method Name - updateCustomer
	*    Parameter List - CustomerDto Object
	*    Return Type - ResponseEntity Object
	*    Description - Update a customer object of the database 
	*/
	@PutMapping
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerdto) throws CustomerNotFoundException {
		
			return new ResponseEntity<CustomerDto>(customerService.updateCustomer(customerdto), HttpStatus.NOT_FOUND);		
	}
	
	/*
	*    Method Name - viewCustomer
	*    Parameter List - CustomerDto Object
	*    Return Type - ResponseEntity Object
	*    Description - To view a customer object from the database with an Id 
	*/
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> viewCustomer(@PathVariable("driverId") int id) throws CustomerNotFoundException {
		
		return new ResponseEntity<CustomerDto>(customerService.viewCustomer(id),HttpStatus.OK);
	}
	
	/*
	 *    Method Name - deleteCustomer
	 *    Parameter List - CustomerDto Object
	 *    Return Type - ResponseEntity Object
	 *    Description - To Delete a customer object from the database with an Id 
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable("id") int id) throws CustomerNotFoundException {
		return new ResponseEntity<CustomerDto>(customerService.deleteCustomer(id),HttpStatus.OK);
	}
	
	/*
	*    Method Name - getAllCustomers
	 *    Parameter List - CustomerDto Object
	 *    Return Type - List Object
	 *    Description - To view all the customer from the database 
	 */
	@GetMapping("/{customerId}")
	public ResponseEntity <List<CustomerDto>> viewCustomers(@PathVariable("customerId")int customerId) throws CustomerNotFoundException {
		
		List<CustomerDto> clist = customerService.viewCustomers();
		return new  ResponseEntity <List<CustomerDto>>(clist,HttpStatus.OK);
	}
}