package com.parking.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.parking.dtos.spots.SpotDto;
import com.parking.models.Spot;

@Mapper
public interface SpotMapper {
	
	SpotMapper INSTANCE = Mappers.getMapper(SpotMapper.class);
	
	Spot dtoToSpot(SpotDto dto);
}
