package io.javabrains.springbootstarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class flightservice {
	private List<Flights> flight = new ArrayList<> (Arrays.asList(
			new Flights("100","Indigo","Bangalore-to-California"),
			new Flights("200","Spice-Jet","Mumbai-to-London"),
			new Flights("300","Emirates","Bangalore-to-Berlin"),
			new Flights("400","AirBus","Pune-to-Paris"),
			new Flights("500","British-Airways","Bangalore-to-Dubai")
		));
	
	public List<Flights> getAllFlights() {
		return flight;
	}
	
	public Flights getflight(String id) {
		return flight.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void addflights(Flights flight2) {
		flight.add(flight2);
	}

	public void updateflights(Flights flight2, String id) {
		for(int i = 0; i < flight.size(); i++) {
			Flights f = flight.get(i);
			if(f.getId().equals(id)) {
				flight.set(i, flight2);
			}
		}
	}

	public void deleteflights(String id) {
		flight.removeIf(t -> t.getId().equals(id));
	}
}
