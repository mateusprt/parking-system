package com.parking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dtos.RoleDto;
import com.parking.exceptions.ResourceNotFoundException;
import com.parking.models.Role;
import com.parking.repositories.RolesRepository;

@Service
public class RolesService {
	
	@Autowired
	private RolesRepository rolesRepository;
	
	public List<Role> getAllRoles() {
		return this.rolesRepository.findAll();
	}
	
	public void create(RoleDto roleDto) {
		Role role = new Role();
		role.setName(roleDto.getName());
		this.rolesRepository.save(role);
	}
	
	public void update(RoleDto roleDto) {
		Role role = new Role();
		role.setName(roleDto.getName());
		this.rolesRepository.save(role);
	}
	
	public void delete(Long id) {
		Role role = this.rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
		this.rolesRepository.delete(role);
	}

}
