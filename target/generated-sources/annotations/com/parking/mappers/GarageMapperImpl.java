package com.parking.mappers;

import com.parking.dtos.garage.GarageDto;
import com.parking.dtos.garage.ShowGarageDto;
import com.parking.dtos.state.StateDto;
import com.parking.models.Garage;
import com.parking.models.State;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T13:13:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
*/
public class GarageMapperImpl implements GarageMapper {

    @Override
    public ShowGarageDto garageToDto(Garage garage) {
        if ( garage == null ) {
            return null;
        }

        ShowGarageDto showGarageDto = new ShowGarageDto();

        showGarageDto.setZipCode( garage.getZipCode() );
        showGarageDto.setStreet( garage.getStreet() );
        showGarageDto.setDistrict( garage.getDistrict() );
        showGarageDto.setAddressNumber( garage.getAddressNumber() );
        showGarageDto.setState( stateToStateDto( garage.getState() ) );
        showGarageDto.setRateCompact( garage.getRateCompact() );
        showGarageDto.setRateRegular( garage.getRateRegular() );
        showGarageDto.setRateLarge( garage.getRateLarge() );
        showGarageDto.setCreatedAt( garage.getCreatedAt() );

        return showGarageDto;
    }

    @Override
    public Garage dtoToGarage(GarageDto dto) {
        if ( dto == null ) {
            return null;
        }

        Garage garage = new Garage();

        garage.setZipCode( dto.getZipCode() );
        garage.setStreet( dto.getStreet() );
        garage.setDistrict( dto.getDistrict() );
        garage.setAddressNumber( dto.getAddressNumber() );
        garage.setRateCompact( dto.getRateCompact() );
        garage.setRateRegular( dto.getRateRegular() );
        garage.setRateLarge( dto.getRateLarge() );

        return garage;
    }

    protected StateDto stateToStateDto(State state) {
        if ( state == null ) {
            return null;
        }

        StateDto stateDto = new StateDto();

        stateDto.setName( state.getName() );

        return stateDto;
    }
}
