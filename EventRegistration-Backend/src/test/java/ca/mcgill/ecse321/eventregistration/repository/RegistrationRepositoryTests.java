package ca.mcgill.ecse321.eventregistration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ca.mcgill.ecse321.eventregistration.model.InPersonEvent;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Registration;

@SpringBootTest
public class RegistrationRepositoryTests {
    @Autowired
    private PersonRepository personRepo;
    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private RegistrationRepository registrationRepo;

    @BeforeEach
    @AfterEach
    public void clearDatabase() {
        registrationRepo.deleteAll();
        personRepo.deleteAll();
        eventRepo.deleteAll();
    }

    @Test
    public void testCreateAndReadRegistration() {
        String personName = "Bob";
        String emailAddress = "bob@yahoo.com";
        String password = "123";
        Date creationDate = Date.valueOf("2024-02-09");
        Person bob = new Person(personName, emailAddress, password, creationDate);
        bob = personRepo.save(bob);

        String eventName = "McGill Juggling Fest";
        Date date = Date.valueOf("2024-02-09");
        Time startTime = Time.valueOf("17:25:00");
        Time endTime = Time.valueOf("23:59:59");
        int limit = 4;
        String address = "McGill";
        InPersonEvent juggling = new InPersonEvent(eventName, date, startTime, endTime, limit, address);
        juggling = eventRepo.save(juggling);

        Registration.Key key = new Registration.Key(bob, juggling);
        Registration reg = new Registration(key);

        reg = registrationRepo.save(reg);

        Registration regFromDb = registrationRepo.findRegistrationByKey(key);

        assertNotNull(regFromDb);
        assertNotNull(regFromDb.getKey());
        assertNotNull(regFromDb.getKey().getRegistrant());
        assertEquals(bob.getId(), regFromDb.getKey().getRegistrant().getId());
        assertNotNull(regFromDb.getKey().getEvent());
        assertEquals(juggling.getId(), regFromDb.getKey().getEvent().getId());
    }
}