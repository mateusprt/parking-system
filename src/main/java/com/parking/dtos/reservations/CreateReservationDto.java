package com.parking.dtos.reservations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parking.models.VehicleType;

import jakarta.validation.constraints.NotNull;

public class CreateReservationDto {
	
	@JsonProperty("garage_id")
	@NotNull(message = "garage_id can't be blank")
	private Long garageId;
	
	@JsonProperty("spot_id")
	@NotNull(message = "spot_id can't be blank")
	private Long spotId;
	
	@JsonProperty("vehicle_type")
	@NotNull(message = "vehicle_type can't be blank")
	private VehicleType vehicleType;

	public Long getGarageId() {
		return garageId;
	}

	public void setGarageId(Long garageId) {
		this.garageId = garageId;
	}

	public Long getSpotId() {
		return spotId;
	}

	public void setSpotId(Long spotId) {
		this.spotId = spotId;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	
}
