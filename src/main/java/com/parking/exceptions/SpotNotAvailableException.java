package com.parking.exceptions;

public class SpotNotAvailableException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public SpotNotAvailableException(String msg) {
		super(msg);
	}

}
