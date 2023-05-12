package com.parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dtos.AuthenticationRequestDto;
import com.parking.dtos.AuthenticationResponseDto;
import com.parking.dtos.RegistrationRequestDto;
import com.parking.dtos.ResponseRequestDto;
import com.parking.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseRequestDto> register(@Valid @RequestBody RegistrationRequestDto registrationBody) {
		this.authService.register(registrationBody);
		return ResponseEntity.ok(new ResponseRequestDto("Account created sucessfully! A verification link was sent to your email."));
	}
	
	@PostMapping("/confirmation/{confirmationToken}")
	public ResponseEntity<ResponseRequestDto> confirmation(@PathVariable("confirmationToken") String confirmationToken) {
		this.authService.confirm(confirmationToken);
		return ResponseEntity.ok(new ResponseRequestDto("Account verified!"));
	}
	
	@PostMapping("/authentication")
	public ResponseEntity<AuthenticationResponseDto> authentication(@Valid @RequestBody AuthenticationRequestDto authenticationRequest) {
		String token = this.authService.authenticate(authenticationRequest);
		return ResponseEntity.ok(new AuthenticationResponseDto(token));
	}
	
}
