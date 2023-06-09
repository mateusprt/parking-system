package com.parking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedVehicleTypeException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public UnsupportedVehicleTypeException(String msg) {
		super(msg);
	}
	
}
