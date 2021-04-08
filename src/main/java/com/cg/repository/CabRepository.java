package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Cab;
@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
	@Query("SELECT e FROM Cab e WHERE e.carType=?1")
	List<Cab> findByCarType(String carType);

	int countByCarType(String carType);
	List<Cab> findByBookedFalse();
}
