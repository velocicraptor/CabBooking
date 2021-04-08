package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Driver;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

	@Query("SELECT e FROM AbstractUser e WHERE e.username=?1")
	public Optional<Driver> findByUsername(String username);
	
	@Query("SELECT e FROM Driver e WHERE e.rating=?1")
	public List<Driver> findByRatingGreaterThanEqual(float rating);

}
