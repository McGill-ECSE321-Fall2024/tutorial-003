package ca.mcgill.ecse321.eventregistration.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return repo.findPersonById(pid);
	}
}
