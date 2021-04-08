package com.cg.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.dto.AdminDto;
import com.cg.dto.TripBookingDto;
import com.cg.exception.AdminAlreadyExistsException;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;

public interface IAdminService {

	public AdminDto insertAdmin(AdminDto admin) throws AdminAlreadyExistsException;
	public AdminDto updateAdmin(AdminDto admin) throws AdminNotFoundException;
	public AdminDto deleteAdmin(int adminId) throws AdminNotFoundException;
	public List<TripBookingDto>getAllTrips(int customerId) throws CustomerNotFoundException;
	public List<TripBookingDto>getTripsCabwise(int cabId);

	public List<TripBookingDto> getTripsDatewise(LocalDateTime fromDate);
	public List<TripBookingDto>getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) throws CustomerNotFoundException;
	
	public AdminDto viewAdmin(int adminId) throws AdminNotFoundException;
	
}
