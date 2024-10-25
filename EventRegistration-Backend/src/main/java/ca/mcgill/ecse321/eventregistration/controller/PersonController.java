package ca.mcgill.ecse321.eventregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.eventregistration.dto.PersonRequestDto;
import ca.mcgill.ecse321.eventregistration.dto.PersonResponseDto;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;

	@PostMapping("/people")
	public PersonResponseDto createPerson(@RequestBody PersonRequestDto personToCreate) {
		Person createdPerson = personService.createPerson(
				personToCreate.getName(),
				personToCreate.getEmailAddress(),
				personToCreate.getPassword());
		return new PersonResponseDto(createdPerson);
	}

	@GetMapping("/people/{pid}")
	public PersonResponseDto findPersonById(@PathVariable int pid) {
		Person createdPerson = personService.findPersonById(pid);
		return new PersonResponseDto(createdPerson);
	}
}
