package com.parking.mappers;

import com.parking.dtos.reservations.ResponseReservationDto;
import com.parking.models.Reservation;
import com.parking.models.Spot;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-23T16:04:29-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
*/
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ResponseReservationDto reservationToDto(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ResponseReservationDto responseReservationDto = new ResponseReservationDto();

        responseReservationDto.setSpotId( reservationSpotId( reservation ) );
        responseReservationDto.setCod( reservation.getCod() );
        responseReservationDto.setStartTime( reservation.getStartTime() );

        return responseReservationDto;
    }

    private Long reservationSpotId(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        Spot spot = reservation.getSpot();
        if ( spot == null ) {
            return null;
        }
        Long id = spot.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
