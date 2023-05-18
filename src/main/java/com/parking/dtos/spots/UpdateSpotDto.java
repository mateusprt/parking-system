package com.parking.dtos.spots;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parking.models.Status;
import com.parking.models.VehicleType;

public class UpdateSpotDto {
	
	@JsonProperty("vehicle_type")
	private VehicleType vehicleType;
	
	private Status status;

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
