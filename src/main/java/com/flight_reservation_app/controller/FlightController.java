package com.flight_reservation_app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entities.Flight;
import com.flight_reservation_app.repository.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepo;
     
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy")Date departureDate, ModelMap modelMap) {
		List<Flight> findFlight = flightRepo.findFlight(from,to,departureDate);
		modelMap.addAttribute("findFlight", findFlight);
		return "displayFlights";
	}
	
	
	
	
	
	
	
	
}
