package io.javabrains.springbootstarter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
	
	@Autowired
	private flightservice flight_service;
	
	@RequestMapping("/flights")
	public List<Flights> getAllFlights() {
		return flight_service.getAllFlights();
	}
	
	@RequestMapping("/flights/{id}")
	public Flights getFlight(@PathVariable String id) {
		return flight_service.getflight(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/flights") 
	public void addFlights(@RequestBody Flights flight) {
		flight_service.addflights(flight);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/flights/{id}") 
	public void updateFlights(@RequestBody Flights flight, @PathVariable String id) {
		flight_service.updateflights(flight,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/flights/{id}") 
	public void deleteFlights(@PathVariable String id) {
		flight_service.deleteflights(id);
	}
}
