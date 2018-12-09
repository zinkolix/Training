package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import repository.FlightRepository;
import validator.AddFlightValidator;
import entity.Flight;
import form.FlightForm;

@Controller
public class Example8Controller {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private AddFlightValidator validator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	   binder.setValidator(validator);
	}
	
	@RequestMapping("/example8/add")
	public String add(@ModelAttribute("flight") FlightForm flightForm) {
		flightForm.setFrom("GOA");
		return "example8";
	}	
	
	@RequestMapping("/example8/save")
	public ModelAndView save(@ModelAttribute("flight") @Validated FlightForm flightForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			return new ModelAndView("example8");
		
		//We can use BeanUtils.copyProperties method instead
		Flight flight = new Flight();
		flight.setFlightNo(flightForm.getFlightNo());
		flight.setCarrier(flightForm.getCarrier());
		flight.setFrom(flightForm.getFrom());
		flight.setTo(flightForm.getTo());
		flightRepository.newFlight(flight);
		
		ModelAndView mav = new ModelAndView("example6Output");
		mav.addObject("message", "Record added successfully!");
		return mav;
	}
	
}
