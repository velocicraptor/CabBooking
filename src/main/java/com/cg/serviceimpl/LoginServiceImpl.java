package com.cg.serviceimpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Convertor;
import com.cg.dto.AdminDto;
import com.cg.dto.CustomerDto;
import com.cg.dto.DriverDto;
import com.cg.entities.Admin;
import com.cg.entities.Customer;
import com.cg.repository.AdminRepository;
import com.cg.entities.Driver;
import com.cg.repository.CustomerRepository;
import com.cg.repository.DriverRepository;
import com.cg.service.ILoginService;



@Service
@Transactional
public class LoginServiceImpl implements ILoginService {
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	DriverRepository driverRepository;

	/*
	 *	Method Name - login
	 *	Return Type - Boolean
	 *	Description - login of users 
	 */
	@Override
	public boolean login(String username, String password, String loginType) {

		if (loginType.equals("Admin")) {
			Optional<Admin> admin = adminRepository.findByUsername(username);
			Admin admin1 = admin.get();
			if (admin1.getUsername().equals(username) && admin1.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} else if (loginType.equals("Customer")) {
			Optional<Customer> customer = customerRepository.findByUsername(username);
			Customer customer1 = customer.get();
			if (customer1.getUsername().equals(username) && customer1.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} else if (loginType.equals("Driver")) {
			Optional<Driver> driver = driverRepository.findByUsername(username);
			Driver driver1 = driver.get();
			if (driver1.getUsername().equals(username) && driver1.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/*
	 *	Method Name - RegisterUser
	 * 	Parameter List - AdminDto object
	 *	Return Type - Boolean
	 *	Description - register a admin object into the database 
	 */

	@Override
	public boolean registerAdmin(AdminDto adminDto) {
		if (adminDto == null) {
			return false;
		}
		Optional<Admin> admin1 = adminRepository
				.findByUsername(Convertor.convertAdminDTOtoEntity(adminDto).getUsername());
		if (admin1.isPresent()) {
			return false;
		}
		adminRepository.save(Convertor.convertAdminDTOtoEntity(adminDto));
		return true;

	}

	/*
	 *	Method Name - RegisterUser
	 * 	Parameter List - CustomerDto object
	 *	Return Type - Boolean 
	 *	Description - register a Customer object into the database 
	 */
	@Override
	public boolean registerCustomer(CustomerDto customerDto) {
		if (customerDto == null) {
			return false;
		}
		Optional<Customer> customer1 = customerRepository
				.findByUsername(Convertor.convertCustomerDTOtoEntity(customerDto).getUsername());
		if (customer1.isPresent()) {
			return false;
		}
		customerRepository.save(Convertor.convertCustomerDTOtoEntity(customerDto));
		return true;
	}

	/*
	 *	Method Name - RegisterUser
	 * 	Parameter List - DriverDto object
	 *	Return Type - Boolean
	 *	Description - register a driver object into the database 
	 */
	@Override
	public boolean registerDriver(DriverDto driverDto) {
		if (driverDto == null) {
			return false;
		}
		Optional<Driver> driver1 = driverRepository
				.findByUsername(Convertor.convertDriverDTOtoEntity(driverDto).getUsername());
		if (driver1.isPresent()) {
			return false;
		}
		driverRepository.save(Convertor.convertDriverDTOtoEntity(driverDto));
		return true;
	}

}
