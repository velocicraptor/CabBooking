package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("SELECT e FROM AbstractUser e WHERE e.username=?1")
	public Optional<Admin> findByUsername(String username);
}
