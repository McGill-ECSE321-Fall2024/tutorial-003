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
        // Create Person
        String name = "Bob";
        String emailAddress = "bob@yahoo.com";
        String password = "123";
        Date creationDate = Date.valueOf("2024-02-09");
        Person bob = new Person(name, emailAddress, password, creationDate);

        // Save in the database
        bob = repo.save(bob);
        int bobId = bob.getId();

        // Read back from the database
        Person bobFromDb = repo.findPersonById(bobId);

        // Assertions
        assertNotNull(bobFromDb);
        assertEquals(bobId, bobFromDb.getId());
        assertEquals(name, bobFromDb.getName());
        assertEquals(emailAddress, bobFromDb.getEmailAddress());
        assertEquals(password, bobFromDb.getPassword());
        assertEquals(creationDate, bobFromDb.getCreationDate());
    }
}
