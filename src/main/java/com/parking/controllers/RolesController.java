package com.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dtos.role.RoleDto;
import com.parking.services.RolesService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/roles")
public class RolesController {
	
	@Autowired
	private RolesService rolesService;
	
	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<List<RoleDto>> list() {
		List<RoleDto> roles = this.rolesService.getAllRoles();
		return ResponseEntity.ok(roles);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RolesAllowed("ADMIN")
	public ResponseEntity<Void> create(@Valid @RequestBody RoleDto roleDto) {
		this.rolesService.create(roleDto);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	@RolesAllowed("ADMIN")
	public void update(@Valid @RequestBody RoleDto roleDto) {
		this.rolesService.update(roleDto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@RolesAllowed("ADMIN")
	public void delete(@PathVariable("id") Long id) {
		this.rolesService.delete(id);
	}
}
