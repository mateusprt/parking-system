package com.parking.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.parking.dtos.AuthenticationRequestDto;
import com.parking.dtos.RegistrationRequestDto;
import com.parking.exceptions.ResourceNotFoundException;
import com.parking.models.Role;
import com.parking.models.User;
import com.parking.repositories.RolesRepository;
import com.parking.repositories.UsersRepository;

@Service
public class AuthService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;

	public void register(RegistrationRequestDto registrationRequest) {
		User userExists = this.usersRepository.findByEmail(registrationRequest.getEmail()).orElseThrow();
		
		if(userExists != null) {
			throw new BadCredentialsException("User already exists");
		}
		
		boolean passwordMatch = registrationRequest.getPassword().equals(registrationRequest.getPasswordConfirmation());
		
		if(!passwordMatch) {
			throw new BadCredentialsException("Passwords doesn't match");
		}
		
		User newUser = new User();
		newUser.setEmail(registrationRequest.getEmail());
		
		String passwordHashed = this.passwordEncoder.encode(registrationRequest.getPassword());
		newUser.setPassword(passwordHashed);
		
		String confirmationToken = UUID.randomUUID().toString();
		newUser.setConfirmationToken(confirmationToken);
		newUser.setConfirmationTokenSentAt(new Date());
		
		Role role = this.rolesRepository.findByName("USER");
		newUser.setRole(role);
		newUser.setCreatedAt(new Date());
		newUser.setUpdatedAt(new Date());
		
		this.usersRepository.save(newUser);
	}
	
	public void confirm(String confirmationToken) {
		User userFound = this.usersRepository.findByConfirmationToken(confirmationToken).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		userFound.setConfirmedAt(new Date());
		userFound.setUnconfirmed(false);
		this.usersRepository.save(userFound);
	}
	
	public String authenticate(AuthenticationRequestDto authenticationRequest) {
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		User  userFound = this.usersRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
		return this.jwtService.generateToken(userFound);
	}

}
