package com.cg.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.service.IDriverService;

import com.cg.Convertor;
import com.cg.dto.DriverDto;
import com.cg.entities.Driver;
import com.cg.exception.DriverAlreadyExistsException;
import com.cg.exception.DriverNotFoundException;
import com.cg.repository.DriverRepository;



@Service
@Transactional
public class DriverServiceImpl implements IDriverService{

	@Autowired
	private DriverRepository driverRepository;
	
	/*
	 *	Method Name - insertDriver
	 * 	Parameter List - DriverDto object
	 *	Return Type - DriverDto object 
	 *	Description - To inserts a driver object into the database 
	 */
	@Override
	public DriverDto insertDriver(DriverDto driver) throws DriverAlreadyExistsException {

		// To check if driver object is null or not
		if(driver==null) 
			return null;
		Optional<Driver> driverOptional = driverRepository.findByUsername(Convertor.convertDriverDTOtoEntity(driver).getUsername());
		if (driverOptional.isPresent()) {
	
			throw new DriverAlreadyExistsException("Driver Username Already Exists");
		}
		Driver driverEntity = Convertor.convertDriverDTOtoEntity(driver);

		return Convertor.convertDriverEntitytoDTO(driverRepository.save(driverEntity));
	}

	/*
	 *	Method Name - updateDriver
	 * 	Parameter List - DriverDto object
	 *	Return Type - DriverDto object 
	 *	Description - To update a driver object in the database 
	 */
	@Override
	public DriverDto updateDriver(DriverDto driver) throws DriverNotFoundException {

		// To check if driver object is null or not
		if(driver==null) 
			return null;
		Optional<Driver> driverOptional = driverRepository.findByUsername(Convertor.convertDriverDTOtoEntity(driver).getUsername());
		if (driverOptional.isPresent()) {
		
			return Convertor.convertDriverEntitytoDTO(driverRepository.save(Convertor.convertDriverDTOtoEntity(driver)));
		}
	
		throw new DriverNotFoundException("Driver not found with username: " + Convertor.convertDriverDTOtoEntity(driver).getUsername());
	}

	/*
	 *	Method Name - deleteDriver
	 * 	Parameter List - int driverId (id of the driver)
	 *	Return Type - DriverDto object 
	 *	Description - To delete a driver object from the database using the driver id
	 */
	@Override
	public DriverDto deleteDriver(int driverId) throws DriverNotFoundException {
		
		Optional<Driver> driverOptional = driverRepository.findById(driverId);
		if (driverOptional.isPresent()) {
		
			driverRepository.deleteById(driverId);
			return Convertor.convertDriverEntitytoDTO(driverOptional.get());
		}
		
		throw new DriverNotFoundException("Driver not found with id: " + driverId);
	}

	/*
	 *	Method Name - viewBestDrivers
	 * 	Parameter List - None
	 *	Return Type - List of DriverDto objects 
	 *	Description - To view list of drivers from the database who has rating greater than or equal to 4.5
	 */
	@Override
	public List<DriverDto> viewBestDrivers() throws DriverNotFoundException {

		List<DriverDto> driverList = new ArrayList<DriverDto>();
		List<Driver> bestDrivers = driverRepository.findByRatingGreaterThanEqual(4.5f);
		if(bestDrivers.isEmpty()) {
	
			throw new DriverNotFoundException("Driver not found with rating greater than or equal to 4.5 ");
		}
		for(Driver driver: bestDrivers) {
			driverList.add(Convertor.convertDriverEntitytoDTO(driver));
		}

		return driverList;
	}

	/*
	 *	Method Name - viewDriver
	 * 	Parameter List - int driverId (id of the driver)
	 *	Return Type - DriverDto object 
	 *	Description - To view a driver object from the database using the driver id
	 */
	@Override
	public DriverDto viewDriver(int driverId) throws DriverNotFoundException {
	
		Optional<Driver> driverOptional = driverRepository.findById(driverId);
		if (driverOptional.isPresent()) {
			
			return Convertor.convertDriverEntitytoDTO(driverOptional.get());
		}
		
		throw new DriverNotFoundException("Driver not found with id: " + driverId);
	}
	
	/*
	 *	Method Name - viewAllDrivers
	 * 	Parameter List - None
	 *	Return Type - List of DriverDto objects
	 *	Description - To view all drivers that are present in the database
	 */
	public List<DriverDto> viewAllDrivers() throws DriverNotFoundException {
		
		List<DriverDto> driverList = new ArrayList<DriverDto>();
		Iterable<Driver> drivers = driverRepository.findAll();
//		List<Driver> drivers = driverRepository.findAll();
		if(drivers == null) {
			
			throw new DriverNotFoundException("Driver not found");
		}
		for(Driver driver: drivers) {
			driverList.add(Convertor.convertDriverEntitytoDTO(driver));
		}
		
		return driverList;
	}
	
}
