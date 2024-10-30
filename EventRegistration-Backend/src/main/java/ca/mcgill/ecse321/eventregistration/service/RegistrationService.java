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

    @Transactional
    public Registration register(Person person, Event event) {
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
    public void unregister(Person person, Event event) {
        Registration existingRegistration = findRegistration(person, event);
        registrationRepo.delete(existingRegistration);
    }

    public Registration findRegistration(Person person, Event event) {
        return registrationRepo.findRegistrationByKey(new Registration.Key(person, event));
    }

    public int countRegistrantsForEvent(Event event) {
        return registrationRepo.countRegistrationsByKeyEvent(event);
    }
}
