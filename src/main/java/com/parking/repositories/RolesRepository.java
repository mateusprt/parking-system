package com.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.models.Role;
import com.parking.models.User;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
	
	public Role findByName(String name);
	
}
