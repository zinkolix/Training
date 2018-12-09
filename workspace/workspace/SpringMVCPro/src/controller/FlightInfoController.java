package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Flight;
import repository.FlightRepository;

@Controller
public class FlightInfoController {

	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping("/flight5Controller")
	public String execute(@RequestParam("flightNo") String flightNo, Map model){
		Flight flight = flightRepository.getFlightInfo(flightNo);
		model.put("flight", flight);
		return "flightInfoOutput";
	}
}
