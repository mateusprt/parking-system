package com.parking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parking.models.Spot;

@Repository
public interface SpotsRepository extends JpaRepository<Spot, Long> {
	
	@Query("SELECT s FROM Spot s WHERE s.garage.id = :garage_id AND s.id = :spot_id")
	Optional<Spot> findSpotByGarageIdAndSpotId(@Param("garage_id") Long garageId, @Param("spot_id") Long spotId);
	
}
