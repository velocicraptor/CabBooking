package com.cg;

import com.cg.dto.AdminDto;
import com.cg.dto.CabDto;
import com.cg.dto.CustomerDto;
import com.cg.dto.DriverDto;
import com.cg.dto.TripBookingDto;
import com.cg.entities.Admin;
import com.cg.entities.Cab;
import com.cg.entities.Customer;
import com.cg.entities.Driver;
import com.cg.entities.TripBooking;

public class Convertor {

	public static CabDto convertCabEntitytoDTO(Cab cab) {
		CabDto cabd = new CabDto();
		cabd.setCarType(cab.getCarType());
		cabd.setPerKmRate(cab.getPerKmRate());
		
		cabd.setCabId(cab.getCabId());
		return cabd;
	}

	public static Cab convertCabDTOtoEntity(CabDto cab) {
		Cab cabd = new Cab();
		cabd.setCarType(cab.getCarType());
		cabd.setPerKmRate(cab.getPerKmRate());
		cabd.setCabId(cab.getCabId());
		return cabd;
	}

	public static DriverDto convertDriverEntitytoDTO(Driver driver) {
		DriverDto driverd = new DriverDto();
		driverd.setDriverId(driver.getDriverId());
		driverd.setUsername(driver.getUsername());
		driverd.setPassword(driver.getPassword());
		driverd.setMobileNumber(driver.getMobileNumber());
		driverd.setEmail(driver.getEmail());
		driverd.setLicenseNo(driver.getLicenseNo());
		driverd.setRating(driver.getRating());
		driverd.setCab(convertCabEntitytoDTO(driver.getCab()));
		return driverd;
	}

	public static Driver convertDriverDTOtoEntity(DriverDto driverd) {
		Driver driver = new Driver();
		driver.setDriverId(driverd.getDriverId());
		driver.setUsername(driverd.getUsername());
		driver.setPassword(driverd.getPassword());
		driver.setMobileNumber(driverd.getMobileNumber());
		driver.setEmail(driverd.getEmail());
		driver.setLicenseNo(driverd.getLicenseNo());
		driver.setRating(driverd.getRating());
		driver.setCab(convertCabDTOtoEntity(driverd.getCab()));
		return driver;
	}

	public static AdminDto convertAdminEntitytoDTO(Admin admin) {
		AdminDto ad = new AdminDto();
		ad.setAdminId(admin.getAdminId());
		ad.setUsername(admin.getUsername());
		ad.setPassword(admin.getPassword());
		ad.setMobileNumber(admin.getMobileNumber());
		ad.setEmail(admin.getEmail());
		return ad;
	}

	public static Admin convertAdminDTOtoEntity(AdminDto admin) {
		Admin ad = new Admin();
		ad.setAdminId(admin.getAdminId());
		ad.setUsername(admin.getUsername());
		ad.setPassword(admin.getPassword());
		ad.setMobileNumber(admin.getMobileNumber());
		ad.setEmail(admin.getEmail());
		return ad;
	}

	public static CustomerDto convertCustomerEntitytoDTO(Customer customer) {
		CustomerDto cust = new CustomerDto();
		cust.setCustomerId(customer.getCustomerId());
		cust.setUsername(customer.getUsername());
		cust.setPassword(customer.getPassword());
		cust.setMobileNumber(customer.getMobileNumber());
		cust.setEmail(customer.getEmail());
		return cust;
	}

	public static Customer convertCustomerDTOtoEntity(CustomerDto customer) {
		Customer cust = new Customer();
		cust.setCustomerId(customer.getCustomerId());
		cust.setUsername(customer.getUsername());
		cust.setPassword(customer.getPassword());
		cust.setMobileNumber(customer.getMobileNumber());
		cust.setEmail(customer.getEmail());

		return cust;
	}

	public static TripBookingDto convertTripBookingEntitytoDTO(TripBooking tripbooking) {
		TripBookingDto tripd = new TripBookingDto();
		tripd.setBill(tripbooking.getBill());
		tripd.setCustomer(convertCustomerEntitytoDTO(tripbooking.getCustomer()));
		tripd.setDistanceInKm(tripbooking.getDistanceInKm());
		tripd.setDriver(convertDriverEntitytoDTO(tripbooking.getDriver()));
		tripd.setFromDateTime(tripbooking.getFromDateTime());
		tripd.setFromLocation(tripbooking.getFromLocation());
		tripd.setToDateTime(tripbooking.getToDateTime());
		tripd.setStatus(tripbooking.isStatus());
		tripd.setToLocation(tripbooking.getToLocation());
		tripd.setTripBookingId(tripbooking.getTripBookingId());

		return tripd;
	}

	public static TripBooking convertTripBookingDTOtoEntity(TripBookingDto tripbooking) {
		TripBooking tripbookingd = new TripBooking();
		tripbookingd.setBill(tripbooking.getBill());
		tripbookingd.setCustomer(convertCustomerDTOtoEntity(tripbooking.getCustomer()));
		tripbookingd.setDistanceInKm(tripbooking.getDistanceInKm());
		tripbookingd.setDriver(convertDriverDTOtoEntity(tripbooking.getDriver()));
		tripbookingd.setFromDateTime(tripbooking.getFromDateTime());
		tripbookingd.setFromLocation(tripbooking.getFromLocation());
		tripbookingd.setStatus(tripbooking.isStatus());
		tripbookingd.setToDateTime(tripbookingd.getToDateTime());
		tripbookingd.setToLocation(tripbooking.getToLocation());
		tripbookingd.setTripBookingId(tripbooking.getTripBookingId());
		return tripbookingd;
	}

} 
