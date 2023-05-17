package com.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.models.Garage;

@Repository
public interface GaragesRepository extends JpaRepository<Garage, Long> {

}
