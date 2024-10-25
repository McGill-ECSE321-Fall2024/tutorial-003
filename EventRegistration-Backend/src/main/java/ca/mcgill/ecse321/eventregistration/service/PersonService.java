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
    private PersonRepository personRepo;

    @Transactional
    public Iterable<Person> findAllPeople() {
        return personRepo.findAll();
    }

    @Transactional
    public Person findPersonById(int pid) {
        Person p = personRepo.findPersonById(pid);
        if (p == null) {
            throw new IllegalArgumentException("There is no person with ID " + pid + ".");
        }
        return p;
    }

    @Transactional
    public Person createPerson(String name, String email, String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password too short.");
        }

        Date now = Date.valueOf(LocalDate.now());
        Person personToCreate = new Person(name, email, password, now);
        return personRepo.save(personToCreate);
    }
}
