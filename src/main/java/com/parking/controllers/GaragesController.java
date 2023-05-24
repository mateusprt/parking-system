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
import org.springframework.web.bind.annotation.RestController;

import com.parking.dtos.garage.GarageDto;
import com.parking.dtos.garage.ShowGarageDto;
import com.parking.dtos.spots.SpotDto;
import com.parking.dtos.spots.UpdateSpotDto;
import com.parking.services.GaragesService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/garages")
public class GaragesController {
	
	@Autowired
	private GaragesService garagesService;
	
	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<List<ShowGarageDto>> list() {
		return ResponseEntity.ok(this.garagesService.listAllGarages());
	}
	
	@PostMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<Void> create(@Valid @RequestBody GarageDto garageDto) {
		this.garagesService.createGarage(garageDto);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}") 
	@RolesAllowed("ADMIN")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @Valid @RequestBody GarageDto garageDto) {
		this.garagesService.updateGarage(id, garageDto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@RolesAllowed("ADMIN")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.garagesService.deleteGarage(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/{id}/spots")
	@RolesAllowed("ADMIN")
	public ResponseEntity<Void> createSpot(@PathVariable("id") Long id, @Valid @RequestBody SpotDto dto) {
		this.garagesService.createSpotOfGarage(id, dto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}/spots/{spotId}")
	@RolesAllowed("ADMIN")
	public ResponseEntity<Void> updateSpot(@PathVariable("id") Long id, @PathVariable("spotId") Long spotId, @RequestBody UpdateSpotDto dto) {
		this.garagesService.updateSpotOfGarage(id, spotId, dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}/spots/{spotId}")
	@RolesAllowed("ADMIN")
	public ResponseEntity<Void> deleteSpot(@PathVariable("id") Long id, @PathVariable("spotId") Long spotId) {
		this.garagesService.deleteSpotOfGarage(id, spotId);
		return ResponseEntity.ok().build();
	}
	
}
