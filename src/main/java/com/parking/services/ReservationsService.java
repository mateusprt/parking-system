package com.parking.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.parking.dtos.reservations.CreateReservationDto;
import com.parking.dtos.reservations.ResponseReservationDto;
import com.parking.exceptions.ResourceNotFoundException;
import com.parking.exceptions.SpotNotAvailableException;
import com.parking.exceptions.UnsupportedVehicleTypeException;
import com.parking.mappers.ReservationMapper;
import com.parking.models.Garage;
import com.parking.models.Reservation;
import com.parking.models.Spot;
import com.parking.models.Status;
import com.parking.models.User;
import com.parking.models.VehicleType;
import com.parking.repositories.GaragesRepository;
import com.parking.repositories.ReservationsRepository;
import com.parking.repositories.SpotsRepository;
import com.parking.repositories.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationsService {
	
	@Autowired
	private SpotsRepository spotsRepository;
	
	@Autowired
	private GaragesRepository garagesRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ReservationsRepository reservationsRepository;
	
	public List<ResponseReservationDto> listAllReservations() {
		List<Reservation> reservations = this.reservationsRepository.findAll();
		List<ResponseReservationDto> listOfDtos = new ArrayList<>();
		reservations.forEach((reservation) -> {
			listOfDtos.add(ReservationMapper.INSTANCE.reservationToDto(reservation));
		});
		return listOfDtos;
	}
	
	@Transactional
	public ResponseReservationDto createReservation(CreateReservationDto dto) {
		
		Garage garageFound = this.garagesRepository.findById(dto.getGarageId()).orElseThrow(() -> new ResourceNotFoundException("Garage not found"));
		Spot spotAvailable = this.spotsRepository.findSpotByGarageIdAndSpotId(garageFound.getId(), dto.getSpotId()).orElseThrow(() -> new ResourceNotFoundException("Spot is not found"));
		
		boolean spotIsReserved = this.checkIfSpotIsReserved(spotAvailable);
		
		if(spotIsReserved) {
			throw new SpotNotAvailableException("Spot already reserved");
		}
		
		boolean spotBelongsToVehicleType = this.checkIfSpotIsAvailableBasedOnVehicleType(spotAvailable, dto.getVehicleType());
		boolean spotDoesntBelongToVehicleType = !spotBelongsToVehicleType;
		
		if(spotDoesntBelongToVehicleType) {
			throw new SpotNotAvailableException("Spot not available for this type of vehicle");
		}
		
		String emailOfCurrentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = this.usersRepository.findByEmail(emailOfCurrentUser).orElseThrow();
		
		Reservation newReservation = new Reservation();
		
		newReservation.setCod(this.generateCodForReservation());
		newReservation.setUser(currentUser);
		newReservation.setGarage(garageFound);
		newReservation.setSpot(spotAvailable);
		newReservation.setStartTime(new Date());
		
		this.reservationsRepository.save(newReservation);
		spotAvailable.setStatus(Status.RESERVED);
		this.spotsRepository.save(spotAvailable);
		
		ResponseReservationDto responseDto = ReservationMapper.INSTANCE.reservationToDto(newReservation);
		
		return responseDto;
	}
	
	@Transactional
	public void cancelReservation(String cod) {
		Reservation reservation = this.reservationsRepository.findByCod(cod).orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
		Spot spotOfReservation = reservation.getSpot();
		this.reservationsRepository.delete(reservation);
		spotOfReservation.setStatus(Status.AVAILABLE);
		this.spotsRepository.save(spotOfReservation);
	}
	
	private String generateCodForReservation() {
		return UUID.randomUUID().toString();
	}
	
	private boolean checkIfSpotIsReserved(Spot spot) {
		return spot.getStatus().equals(Status.RESERVED);
	}
	
	private boolean checkIfSpotIsAvailableBasedOnVehicleType(Spot spotAvailable, VehicleType vehicleTypeFromDto) {
		switch(vehicleTypeFromDto) {
		case COMPACT:
			// compact + regular + large
			break;
		case REGULAR:
			boolean spotIsToRegularOrLargeVehicle = spotAvailable.getVehicleType().equals(vehicleTypeFromDto) || spotAvailable.getVehicleType().equals(VehicleType.LARGE);
			boolean spotIsNotRegularOrLarge = !spotIsToRegularOrLargeVehicle;
			if(spotIsNotRegularOrLarge) {
				return false;
			}
			break;
		case LARGE:
			boolean spotIsForLargeVehicle = spotAvailable.getVehicleType().equals(vehicleTypeFromDto);
			boolean spotIsNotLarge = !spotIsForLargeVehicle;
			if(spotIsNotLarge) {
				return false;
			}
			break;
		default:
			throw new UnsupportedVehicleTypeException("vehicle_type not found");
		}
		return true;
	}

}
