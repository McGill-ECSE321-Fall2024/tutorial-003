package ca.mcgill.ecse321.eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Registration;
import ca.mcgill.ecse321.eventregistration.repository.RegistrationRepository;
import jakarta.transaction.Transactional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepo;
    @Autowired
    private PersonService personService;
    @Autowired
    private EventService eventService;

    @Transactional
    public Registration register(int pid, int eid) {
        Person person = personService.findPersonById(pid);
        Event event = eventService.findEventById(eid);
        Registration existingRegistration = findRegistration(person, event);
        if (existingRegistration != null) {
            // Already registered
            return existingRegistration;
        } else {
            Registration newRegistration = new Registration(new Registration.Key(person, event));
            return registrationRepo.save(newRegistration);
        }
    }

    @Transactional
    public Registration findRegistration(int pid, int eid) {
        Person person = personService.findPersonById(pid);
        Event event = eventService.findEventById(eid);
        return findRegistration(person, event);
    }

    private Registration findRegistration(Person person, Event event) {
        return registrationRepo.findRegistrationByKey(new Registration.Key(person, event));
    }
}
