package com.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation_app.dto.ReservationUpdateRequest;
import com.flight_reservation_app.entities.Reservation;
import com.flight_reservation_app.repository.ReservationRepository;

@RestController
public class ReservationRestfulController {
	@Autowired
	ReservationRepository reservationRepo;
	
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		
		return findById.get();
	}
	
	@RequestMapping("/reservation")
	public void updateReservation(@RequestBody ReservationUpdateRequest request) {
		long id = request.getId();
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(true);
		reservationRepo.save(reservation);
	}
	

}
