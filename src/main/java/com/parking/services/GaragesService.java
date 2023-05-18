package com.parking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dtos.garage.GarageDto;
import com.parking.dtos.garage.ShowGarageDto;
import com.parking.dtos.spots.SpotDto;
import com.parking.dtos.spots.UpdateSpotDto;
import com.parking.exceptions.ResourceNotFoundException;
import com.parking.mappers.GarageMapper;
import com.parking.mappers.SpotMapper;
import com.parking.models.Garage;
import com.parking.models.Spot;
import com.parking.models.State;
import com.parking.models.Status;
import com.parking.repositories.GaragesRepository;
import com.parking.repositories.SpotsRepository;
import com.parking.repositories.StatesRepository;

@Service
public class GaragesService {
	
	@Autowired
	private GaragesRepository garagesRepository;
	
	@Autowired
	private StatesRepository statesRepository;
	
	@Autowired
	private SpotsRepository spotsRepository;
	
	public List<ShowGarageDto> listAllGarages() {
		List<Garage> garages = this.garagesRepository.findAll();
		List<ShowGarageDto> garagesDtos = new ArrayList<>();
		garages.forEach((garage) -> {
			ShowGarageDto dto = GarageMapper.INSTANCE.garageToDto(garage);
			garagesDtos.add(dto);
		});
		return garagesDtos;
	}
	
	public void createGarage(GarageDto garageDto) {
		Garage newGarage = GarageMapper.INSTANCE.dtoToGarage(garageDto);
		State state = this.statesRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("State not found"));
		newGarage.setState(state);
		if(state.getCities().size() > 0) {
			newGarage.setCity(state.getCities().get(0));
		}
		this.garagesRepository.save(newGarage);
	}
	
	public void updateGarage(Long id, GarageDto garageDto) {
		Garage garageFound = this.garagesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Garage not found"));
		garageFound.setZipCode(garageDto.getZipCode());
		garageFound.setStreet(garageDto.getStreet());
		garageFound.setDistrict(garageDto.getDistrict());
		garageFound.setAddressNumber(garageDto.getAddressNumber());
		garageFound.setRateCompact(garageDto.getRateCompact());
		garageFound.setRateRegular(garageDto.getRateRegular());
		garageFound.setRateLarge(garageDto.getRateLarge());
		State state = this.statesRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("State not found"));
		garageFound.setState(state);
		if(state.getCities().size() > 0) {
			garageFound.setCity(state.getCities().get(0));
		}
		this.garagesRepository.save(garageFound);
	}
	
	
	public void deleteGarage(Long id) {
		Garage garageFound = this.garagesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Garage not found"));
		this.garagesRepository.delete(garageFound);
	}
	
	public void createSpotOfGarage(Long id, SpotDto dto) {
		Garage garageFound = this.garagesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Garage not found"));
		Spot newSpot = SpotMapper.INSTANCE.dtoToSpot(dto);
		newSpot.setGarage(garageFound);
		newSpot.setStatus(Status.AVAILABLE);
		this.spotsRepository.save(newSpot);
	}
	
	public void updateSpotOfGarage(Long id, Long spotId, UpdateSpotDto dto) {
		Garage garageFound = this.garagesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Garage not found"));
		Spot spotForUpdate = null;
		for(Spot spot: garageFound.getSpots()) {
			if(spot.getId().equals(spotId)) {
				spotForUpdate = spot;
			}
		}
		if(spotForUpdate == null) {
			throw new ResourceNotFoundException("Spot not found");
		}
		spotForUpdate.setVehicleType(dto.getVehicleType());
		spotForUpdate.setStatus(dto.getStatus());
		this.spotsRepository.save(spotForUpdate);
	}
	
	public void deleteSpotOfGarage(Long id, Long spotId) {
		Garage garageFound = this.garagesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Garage not found"));
		Spot spotForUpdate = null;
		for(Spot spot: garageFound.getSpots()) {
			if(spot.getId().equals(spotId)) {
				spotForUpdate = spot;
			}
		}
		if(spotForUpdate == null) {
			throw new ResourceNotFoundException("Spot not found");
		}
		this.spotsRepository.delete(spotForUpdate);
	}

}
