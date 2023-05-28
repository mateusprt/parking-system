package com.parking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dtos.role.RoleDto;
import com.parking.exceptions.ResourceNotFoundException;
import com.parking.mappers.ApplicationMapper;
import com.parking.models.Role;
import com.parking.repositories.RolesRepository;

@Service
public class RolesService {

	@Autowired
	private RolesRepository rolesRepository;
	
	public List<RoleDto> getAllRoles() {
		List<Role> roles = this.rolesRepository.findAll();
		List<RoleDto> dtos = new ArrayList<>();
		roles.forEach((role) -> {
			RoleDto dto = ApplicationMapper.map(role, RoleDto.class);
			dtos.add(dto);
		});
		return dtos;
	}
	
	public void create(RoleDto roleDto) {
		Role role = ApplicationMapper.map(roleDto, Role.class);
		this.rolesRepository.save(role);
	}
	
	public RoleDto findById(Long id) {
		Role roleFound = this.rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
		RoleDto dto = ApplicationMapper.map(roleFound, RoleDto.class);
		return dto;
	}
	
	public void update(Long id, RoleDto roleDto) {
		Role roleFound = this.rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
		roleFound.setName(roleDto.getName());
		this.rolesRepository.save(roleFound);
	}
	
	public void delete(Long id) {
		Role role = this.rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
		this.rolesRepository.delete(role);
	}

}
