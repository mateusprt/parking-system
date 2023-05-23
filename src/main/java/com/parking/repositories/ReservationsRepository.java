package com.parking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.models.Reservation;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Long> {
	
	Optional<Reservation> findByCod(String cod);
	
}
