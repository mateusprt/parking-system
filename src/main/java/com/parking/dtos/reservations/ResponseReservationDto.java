package com.parking.dtos.reservations;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseReservationDto {
	
	private String cod;
	
	@JsonProperty("spot_id")
	private Long spotId;
	
	@JsonProperty("start_time")
	private Date startTime;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Long getSpotId() {
		return spotId;
	}

	public void setSpotId(Long spotId) {
		this.spotId = spotId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	

}
