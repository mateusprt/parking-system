package com.parking.mappers;

import org.modelmapper.ModelMapper;

public class ApplicationMapper {
	
	private static ModelMapper mapper = new ModelMapper();
	
	public static <S,D> D map(S objectSource, Class<D> destinationClass) {
		return mapper.map(objectSource, destinationClass);
	}
	
}
