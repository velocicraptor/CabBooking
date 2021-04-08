package com.cg.service;

import java.util.List;

import com.cg.dto.CustomerDto;
import com.cg.exception.CustomerAlreadyExistsException;
import com.cg.exception.CustomerNotFoundException;


public interface ICustomerService{

	public CustomerDto insertCustomer(CustomerDto customer) throws CustomerAlreadyExistsException;
	public CustomerDto updateCustomer(CustomerDto customer) throws CustomerNotFoundException;
	public CustomerDto deleteCustomer(int customerId) throws CustomerNotFoundException;
	public List<CustomerDto> viewCustomers() throws CustomerNotFoundException;
	public CustomerDto viewCustomer(int driverId) throws CustomerNotFoundException;
		
}
