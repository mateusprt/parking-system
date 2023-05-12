package com.parking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	Optional<User> findByConfirmationToken(String confirmationToken);

}
