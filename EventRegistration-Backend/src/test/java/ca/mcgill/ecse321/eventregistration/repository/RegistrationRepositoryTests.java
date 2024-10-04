package ca.mcgill.ecse321.eventregistration.repository;

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
		// Arrange
		Person tim = new Person("Tim", "tim@mcgill.ca", "1234", Date.valueOf("2024-10-04"));
		Time startTime = Time.valueOf("17:25:00");
		Time endTime = Time.valueOf("23:59:59");
		int limit = 4;
		String address = "McGill";
		InPersonEvent juggling = new InPersonEvent("McGill Juggling Fest", Date.valueOf("2024-02-09"), startTime,
				endTime, limit, address);

		tim = personRepo.save(tim);
		juggling = eventRepo.save(juggling);

		Registration.Key key = new Registration.Key(tim, juggling);
		Registration reg = new Registration(key);

		reg = registrationRepo.save(reg);

		// Act
		Registration regFromDb = registrationRepo.findRegistrationByKey(key);

		// Assert
		assertNotNull(regFromDb);
		assertNotNull(regFromDb.getKey());
		assertNotNull(regFromDb.getKey().getRegistrant());
		assertNotNull(regFromDb.getKey().getRegistrant().getId() == tim.getId());
		assertNotNull(regFromDb.getKey().getEvent());
		assertNotNull(regFromDb.getKey().getEvent().getId() == juggling.getId());
	}
}
