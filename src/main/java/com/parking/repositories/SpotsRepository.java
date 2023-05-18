package com.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.models.Spot;

@Repository
public interface SpotsRepository extends JpaRepository<Spot, Long> {

}
