package com.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.parking.services.GaragesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/garages")
public class GaragesController {
	
	@Autowired
	private GaragesService garagesService;
	
	@GetMapping
	public ResponseEntity<List<ShowGarageDto>> list() {
		return ResponseEntity.ok(this.garagesService.listAllGarages());
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody GarageDto garageDto) {
		this.garagesService.createGarage(garageDto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @Valid @RequestBody GarageDto garageDto) {
		this.garagesService.updateGarage(id, garageDto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.garagesService.deleteGarage(id);
		return ResponseEntity.ok().build();
	}
	
}
