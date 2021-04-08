package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("SELECT e FROM AbstractUser e WHERE e.username=?1")
	public Optional<Customer> findByUsername(String username);

}
