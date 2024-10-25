package ca.mcgill.ecse321.eventregistration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello there!";
	}

	@GetMapping("/hello/{myName}")
	public String helloWithArgs(@PathVariable String myName, @RequestParam String yourName) {
		return String.format("Hello, %s! My name is %s.", yourName, myName);
	}
}
