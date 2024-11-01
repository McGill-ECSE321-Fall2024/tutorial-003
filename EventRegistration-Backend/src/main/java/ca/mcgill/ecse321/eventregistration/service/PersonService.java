package ca.mcgill.ecse321.eventregistration.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.eventregistration.exception.EventRegistrationException;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.repository.PersonRepository;
import jakarta.transaction.Transactional;

@Service
public class PersonService {
	@Autowired
	private PersonRepository repo;

	@Transactional
	public Person createPerson(String name, String emailAddress, String password) {
		Date today = Date.valueOf(LocalDate.now());
		Person person = new Person(name, emailAddress, password, today);
		return repo.save(person);
	}

	public Person findPersonById(int pid) {
		Person person = repo.findPersonById(pid);
		if (person == null) {
			throw new EventRegistrationException(HttpStatus.NOT_FOUND,
					String.format("There is no person with ID %d.", pid));
		}
		return person;
	}
}
