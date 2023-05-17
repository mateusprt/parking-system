package com.parking.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.parking.dtos.garage.GarageDto;
import com.parking.dtos.garage.ShowGarageDto;
import com.parking.models.Garage;

@Mapper
public interface GarageMapper {
	
	GarageMapper INSTANCE = Mappers.getMapper(GarageMapper.class);
	
	ShowGarageDto garageToDto(Garage garage);
	Garage  dtoToGarage(GarageDto dto);
	
}
