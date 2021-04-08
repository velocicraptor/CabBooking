package com.cg.service;

import java.util.List;

import com.cg.dto.DriverDto;
import com.cg.exception.DriverAlreadyExistsException;
import com.cg.exception.DriverNotFoundException;

public interface IDriverService {

	public DriverDto insertDriver(DriverDto driver) throws DriverAlreadyExistsException;
	public DriverDto updateDriver(DriverDto driver) throws DriverNotFoundException;
	public DriverDto deleteDriver(int driverId) throws DriverNotFoundException;
	public List<DriverDto>viewBestDrivers() throws DriverNotFoundException;
	public DriverDto viewDriver(int driverId) throws DriverNotFoundException;
	
}
