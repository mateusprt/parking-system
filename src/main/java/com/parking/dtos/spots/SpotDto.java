package com.parking.dtos.spots;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parking.models.Status;
import com.parking.models.VehicleType;

import jakarta.validation.constraints.NotNull;

public class SpotDto {
	
	@NotNull(message = "vehicle_type can't be blank")
	@JsonProperty("vehicle_type")
	private VehicleType vehicleType;
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	
}
