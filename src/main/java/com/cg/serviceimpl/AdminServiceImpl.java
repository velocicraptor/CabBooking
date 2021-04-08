package com.cg.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Convertor;

import com.cg.dto.AdminDto;
import com.cg.dto.TripBookingDto;
import com.cg.entities.Admin;
import com.cg.entities.TripBooking;
import com.cg.exception.AdminAlreadyExistsException;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;

import com.cg.repository.AdminRepository;
import com.cg.repository.TripBookingRepository;
import com.cg.service.IAdminService;


@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private TripBookingRepository tripBookingRepository;
	@Override
	
	/*
	 *	Method Name - insertAdmin
	 * 	Parameter List - AdminDto 
	 *	Return Type - AdminDto object 
	 *	Description - insert an admin object into the database 
	 */
	public AdminDto insertAdmin(AdminDto admin) throws AdminAlreadyExistsException {
		if (admin == null)
			return null;
		Optional<Admin> adminOptional = adminRepository.findById(Convertor.convertAdminDTOtoEntity(admin).getAdminId());
		if (adminOptional.isPresent()) {	
			throw new AdminAlreadyExistsException("Admin Username Already Exists");
		}
		Admin adEntity = Convertor.convertAdminDTOtoEntity(admin);
		return Convertor.convertAdminEntitytoDTO(adminRepository.save(adEntity));
	}
	
	/*
	 *	Method Name - updateAdmin
	 * 	Parameter List - AdminDto 
	 *	Return Type - AdminDto object 
	 *	Description - update an admin object into the database 
	 */
	@Override
	public AdminDto updateAdmin(AdminDto admin) throws AdminNotFoundException {
		Optional<Admin> adminOptional = adminRepository.findById(Convertor.convertAdminDTOtoEntity(admin).getAdminId());
		if (adminOptional.isPresent()) {
			return Convertor.convertAdminEntitytoDTO(adminRepository.save(Convertor.convertAdminDTOtoEntity(admin)));
		}
		throw new AdminNotFoundException(
				"Driver not found with username: " + Convertor.convertAdminDTOtoEntity(admin).getAdminId());
	}
	
	/*
	 *	Method Name - deleteAdmin
	 * 	Parameter List - adminId
	 *	Return Type - AdminDto object 
	 *	Description - delete an admin object from the database 
	 */
	@Override
	public AdminDto deleteAdmin(int adminId) throws AdminNotFoundException {	
		Optional<Admin> adminOptional = adminRepository.findById(adminId);
		if (adminOptional.isPresent()) {
			adminRepository.deleteById(adminId);	
			return Convertor.convertAdminEntitytoDTO(adminOptional.get());
		}
		throw new AdminNotFoundException("Admin not found" + adminId);
	}
	
	/*
	 *	Method Name - getAllTrips
	 * 	Parameter List - customerId
	 *	Return Type - TripBookingDto object 
	 *	Description - get the list of all trips from the database 
	 */
	@Override
	public List<TripBookingDto> getAllTrips(int customerId) throws CustomerNotFoundException {
		List<TripBookingDto> tripList = new ArrayList<TripBookingDto>();
		List<TripBooking> allTrips = tripBookingRepository.getAllTripsByCustomer(customerId);
		if (allTrips.isEmpty()) {
			throw new CustomerNotFoundException("Not found ");
		}
		for (TripBooking trip : allTrips) {
			tripList.add(Convertor.convertTripBookingEntitytoDTO(trip));
		}
	
		return tripList;
	}

	/*
	 *	Method Name - getTripsCabwise
	 * 	Parameter List - cabId 
	 *	Return Type - TripBookingDto object 
	 *	Description - get the list of trips in cabwise order from the database 
	 */
	@Override
	public List<TripBookingDto> getTripsCabwise(int cabId) {
		
		List<TripBookingDto> tripList = new ArrayList<TripBookingDto>();
		List<TripBooking> tripsCabwise = tripBookingRepository.getAllTripsByCab(cabId);
		for (TripBooking trip : tripsCabwise) {
			tripList.add(Convertor.convertTripBookingEntitytoDTO(trip));
		}
		return tripList;
	}
	
	/*
	 *	Method Name - getTripsDatewise
	 * 	Parameter List - fromDate
	 *	Return Type - TripBookingDto object 
	 *	Description - get the list of trips in datewise order from the database 
	 */
	@Override
	public List<TripBookingDto> getTripsDatewise(LocalDateTime fromDate) {
		List<TripBookingDto> tripList = new ArrayList<TripBookingDto>();
		List<TripBooking> tripsDatewise = tripBookingRepository.getAllTripsByDate(fromDate);
		for (TripBooking trip : tripsDatewise) {
			tripList.add(Convertor.convertTripBookingEntitytoDTO(trip));
		}
		return tripList;
	}
	
	/*
	 *	Method Name - getTripsAllTripsForDays
	 * 	Parameter List - TripBookingDto 
	 *	Return Type - TripBookingDto object 
	 *	Description - get the list of all trips from and to a specified local date time order from the database 
	 */
	@Override
	public List<TripBookingDto> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException {
		List<TripBookingDto> tripList = new ArrayList<TripBookingDto>();
		List<TripBooking> alltripsForDays = tripBookingRepository.getAllTripsForDays(customerId, fromDate, toDate);
		for (TripBooking trip : alltripsForDays) {
			tripList.add(Convertor.convertTripBookingEntitytoDTO(trip));
		}
		return tripList;
	}
	
	/*
	 *	Method Name - viewAdmin
	 * 	Parameter List - AdminId
	 *	Return Type - AdminDto object 
	 *	Description - view the admin object from the database 
	 */
	@Override
	public AdminDto viewAdmin(int adminId) throws AdminNotFoundException {
		
		Optional<Admin> adminOptional = adminRepository.findById(adminId);
		if (adminOptional.isPresent()) {
			return Convertor.convertAdminEntitytoDTO(adminOptional.get());
		}
		throw new AdminNotFoundException("Admin not found with id: ");
	}
}