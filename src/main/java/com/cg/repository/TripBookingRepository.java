
package com.cg.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.entities.TripBooking;
@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {
	@Query("Select e FROM TripBooking e where e.customerId=?1")
	public List<TripBooking> getAllTripsByCustomer(int customerId);
		
	@Query("SELECT e FROM TripBooking e where e.customerId=?1 and e.fromDate=?2 and e.toDate=?3")
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);

	@Query("SELECT e FROM TripBooking e WHERE e.cabId=?1")
	public List<TripBooking> getAllTripsByCab(int cabId);
	
	@Query ("SELECT e FROM TripBooking e WHERE e.fromDate=?1")
	public List<TripBooking> getAllTripsByDate(LocalDateTime fromDate);
}