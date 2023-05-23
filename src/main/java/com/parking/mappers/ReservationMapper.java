package com.parking.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.parking.dtos.reservations.ResponseReservationDto;
import com.parking.models.Reservation;


@Mapper
public interface ReservationMapper {
	
	ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);
	
	@Mapping(source = "spot.id", target = "spotId")
	ResponseReservationDto reservationToDto(Reservation reservation);	
}
