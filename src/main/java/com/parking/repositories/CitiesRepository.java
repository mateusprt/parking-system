package com.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.models.City;

@Repository
public interface CitiesRepository extends JpaRepository<City, Long> {

}
