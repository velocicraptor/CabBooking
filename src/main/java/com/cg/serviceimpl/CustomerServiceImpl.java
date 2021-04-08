package com.cg.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Convertor;

import com.cg.dto.CustomerDto;
import com.cg.entities.Customer;
import com.cg.exception.CustomerAlreadyExistsException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.repository.CustomerRepository;
import com.cg.service.ICustomerService;



@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/*
	 *    Method Name - insertCustomer
	 *    Parameter List - CustomerDto Object
	 *    Return Type - CustomerDto Object
	 *    Description - Insert a customer object to the database 
	 */
	@Override
	public CustomerDto insertCustomer(CustomerDto customer) throws CustomerAlreadyExistsException {
	
		if (customer == null)
			return null;
		Optional<Customer> customerOptional = customerRepository
				.findById(Convertor.convertCustomerDTOtoEntity(customer).getCustomerId());
		if (customerOptional.isPresent()) {
		
			throw new CustomerAlreadyExistsException("Customer Already Exists");
		}
		Customer customerEntity = Convertor.convertCustomerDTOtoEntity(customer);
		return Convertor.convertCustomerEntitytoDTO(customerRepository.save(customerEntity));
	}

	/*
	 *    Method Name - updateCustomer
	 *    Parameter List - CustomerDto Object
	 *    Return Type - CustomerDto Object
	 *    Description - Update a customer object of the database 
	 */
	@Override
	public CustomerDto updateCustomer(CustomerDto customer) throws CustomerNotFoundException {
	
		Optional<Customer> customerOptional = customerRepository
				.findById(Convertor.convertCustomerDTOtoEntity(customer).getCustomerId());
		if (customerOptional.isPresent()) {
			return Convertor.convertCustomerEntitytoDTO(
					customerRepository.save(Convertor.convertCustomerDTOtoEntity(customer)));
		}
	
		throw new CustomerNotFoundException(
				"Customer not found " + Convertor.convertCustomerDTOtoEntity(customer).getCustomerId());
	}

	/*
	 *    Method Name - deleteCustomer
	 *    Parameter List - CustomerDto Object
	 *    Return Type - CustomerDto Object
	 *    Description - To Delete a customer object from the database with an Id 
	 */
	@Override
	public CustomerDto deleteCustomer(int CustomerId) throws CustomerNotFoundException {
		
		Optional<Customer> customerOptional = customerRepository.findById(CustomerId);
		if (customerOptional.isPresent()) {
			customerRepository.deleteById(CustomerId);
			return Convertor.convertCustomerEntitytoDTO(customerOptional.get());
		}
	
		throw new CustomerNotFoundException("Customer not found with id: " + CustomerId);
	}

	/*
	 *    Method Name - viewCustomer
	 *    Parameter List - CustomerDto Object
	 *    Return Type - CustomerDto Object
	 *    Description - To view a customer object from the database with an Id 
	 */
	@Override
	public List<CustomerDto> viewCustomers() {

		List<CustomerDto> custList = new ArrayList<CustomerDto>();
		Iterable<Customer> custEntity = customerRepository.findAll();
//		List<Customer> custEntity = customerRepository.findAll();
		for (Customer Cust : custEntity) {
			custList.add(Convertor.convertCustomerEntitytoDTO(Cust));
		}
		
		return custList;
	}

	/*
	 *    Method Name - getAllCustomers
	 *    Parameter List - CustomerDto Object
	 *    Return Type - CustomerDto Object
	 *    Description - To view all the customer from the database 
	 */
	@Override
	public CustomerDto viewCustomer(int CustomerId) throws CustomerNotFoundException {
	
		Optional<Customer> customerOptional = customerRepository.findById(CustomerId);
		if (customerOptional.isPresent()) {
			return Convertor.convertCustomerEntitytoDTO(customerOptional.get());
		}
	
		throw new CustomerNotFoundException("Customer not found with id: " + CustomerId);
	}

}