package ca.mcgill.ecse321.eventregistration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.eventregistration.dto.PersonListDto;
import ca.mcgill.ecse321.eventregistration.dto.PersonRequestDto;
import ca.mcgill.ecse321.eventregistration.dto.PersonResponseDto;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.service.PersonService;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/people/{pid}")
    public PersonResponseDto findPersonById(@PathVariable int pid) {
        Person person = personService.findPersonById(pid);
        return new PersonResponseDto(person);
    }

    @GetMapping("/people")
    public PersonListDto findAllPeople() {
        List<PersonResponseDto> people = new ArrayList<PersonResponseDto>();
        for (Person model : personService.findAllPeople()) {
            people.add(new PersonResponseDto(model));
        }
        return new PersonListDto(people);
    }

    /**
     * Create a new person.
     * 
     * @param person The person to create.
     * @return The created person, including their ID.
     */
    @PostMapping("/people")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponseDto createPerson(@RequestBody PersonRequestDto person) {
        Person createdPerson = personService.createPerson(person.getName(), person.getEmailAddress(),
                person.getPassword());
        return new PersonResponseDto(createdPerson);
    }
}
