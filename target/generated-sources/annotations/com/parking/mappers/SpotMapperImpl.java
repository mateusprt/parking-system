package com.parking.mappers;

import com.parking.dtos.spots.SpotDto;
import com.parking.models.Spot;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T10:38:43-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
*/
public class SpotMapperImpl implements SpotMapper {

    @Override
    public Spot dtoToSpot(SpotDto dto) {
        if ( dto == null ) {
            return null;
        }

        Spot spot = new Spot();

        spot.setVehicleType( dto.getVehicleType() );

        return spot;
    }
}
