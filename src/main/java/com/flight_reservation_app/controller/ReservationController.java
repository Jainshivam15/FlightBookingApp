package com.flight_reservation_app.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entities.Flight;
import com.flight_reservation_app.entities.Passenger;
import com.flight_reservation_app.entities.Reservation;
import com.flight_reservation_app.repository.FlightRepository;
import com.flight_reservation_app.repository.PassengerRepository;
import com.flight_reservation_app.repository.ReservationRepository;
import com.flight_reservation_app.util.EmailUtil;
import com.flight_reservation_app.util.PDFGenerator;
@Controller
public class ReservationController {
	
	private static String folderPath = "C:\\STS ver4.18\\flight_reservation_app\\tickets";
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	PDFGenerator pdfGen;
	
	@Autowired
	EmailUtil emailUtil;
	
	
	
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId, ModelMap modelMap) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		 Flight flight = findById.get();
		 modelMap.addAttribute("flight", flight);
		 
		return "showCompleteReservation";
	}
	// took all detail from form & saving in passenger object then put into passenger table using Repo
	@RequestMapping("/confirmReservation")
	public String confirmReservation(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,@RequestParam("middleName") String middleName, @RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Passenger passenger = new Passenger();
		passenger.setFirstName(firstName);
		passenger.setLastName(lastName);
		passenger.setMiddleName(middleName);
		passenger.setEmail(email);
		passenger.setPhone(phone);
		
		passengerRepo.save(passenger);
		// fetching the flight
		
		Optional<Flight> findById = flightRepo.findById(flightId);
		
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		
		reservationRepo.save(reservation);
		
		modelMap.addAttribute("firstName", firstName);
		modelMap.addAttribute("lastName", lastName);
		modelMap.addAttribute("middleName", middleName);
		modelMap.addAttribute("email", email);
		modelMap.addAttribute("phone", phone);
		modelMap.addAttribute("operatingAirlines", flight.getOperatingAirlines());
		modelMap.addAttribute("departureCity", flight.getDepartureCity());
		modelMap.addAttribute("arrivalCity", flight.getArrivalCity());
		modelMap.addAttribute("estimatedDepartureTime", flight.getEstimatedDepartureTime());
		
		String estimatedDepartureTime = flight.getEstimatedDepartureTime().toString();
		
		pdfGen.generatePDF(folderPath+"tickets"+passenger.getId()+".pdf",passenger.getFirstName(),passenger.getEmail(),passenger.getPhone(),flight.getOperatingAirlines(),estimatedDepartureTime,flight.getDepartureCity(),flight.getArrivalCity());
		
		emailUtil.sendItinerary(passenger.getEmail(),folderPath+"tickets"+passenger.getId()+".pdf");
		
		return "confirmationPage";
	}
	

}
