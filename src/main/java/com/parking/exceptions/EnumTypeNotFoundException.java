package com.parking.exceptions;

public class EnumTypeNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public EnumTypeNotFoundException(String msg) {
		super(msg);
	}
	
}
