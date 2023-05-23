package com.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dtos.reservations.CreateReservationDto;
import com.parking.dtos.reservations.ResponseReservationDto;
import com.parking.dtos.shared.ResponseRequestDto;
import com.parking.services.ReservationsService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationsController {
	
	@Autowired
	private ReservationsService reservationsService;
	
	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<List<ResponseReservationDto>> list() {
		return ResponseEntity.ok(this.reservationsService.listAllReservations());
	}
	
	@PostMapping
	public ResponseEntity<ResponseReservationDto> create(@Valid @RequestBody CreateReservationDto dto) {
		ResponseReservationDto responseDto = this.reservationsService.createReservation(dto);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cancel/{cod}")
	public ResponseEntity<ResponseRequestDto> delete(@PathVariable("cod") String cod) {
		this.reservationsService.cancelReservation(cod);
		return ResponseEntity.ok(new ResponseRequestDto("Reservation canceled successfully"));
	}
	
}
