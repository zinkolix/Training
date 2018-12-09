package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example4Controller {

	@RequestMapping("/example4")
	public @ResponseBody String handleRequest() {  // Restful way of doing it
		return "Welcome to Spring MVC";
	}
}
