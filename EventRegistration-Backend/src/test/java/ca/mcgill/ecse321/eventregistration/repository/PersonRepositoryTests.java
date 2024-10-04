package ca.mcgill.ecse321.eventregistration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ca.mcgill.ecse321.eventregistration.model.Person;

@SpringBootTest
public class PersonRepositoryTests {
	@Autowired
	private PersonRepository repo;

	@BeforeEach
	@AfterEach
	public void clearDatabase() {
		repo.deleteAll();
	}

	@Test
	public void testCreateAndReadPerson() {
		// Arrange
		Person tim = new Person("Tim", "tim@mcgill.ca", "1234", Date.valueOf("2024-10-04"));
		tim = repo.save(tim);
		int id = tim.getId();

		// Act
		Person timFromDb = repo.findPersonById(id);

		// Assert
		assertNotNull(timFromDb);
		assertEquals(id, timFromDb.getId());
		assertEquals(tim.getName(), timFromDb.getName());
		assertEquals(tim.getEmailAddress(), timFromDb.getEmailAddress());
		assertEquals(tim.getPassword(), timFromDb.getPassword());
		assertEquals(tim.getCreationDate(), timFromDb.getCreationDate());
	}
}
