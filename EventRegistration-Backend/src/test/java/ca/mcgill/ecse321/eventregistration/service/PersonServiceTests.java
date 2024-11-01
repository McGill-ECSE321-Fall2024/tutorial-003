package ca.mcgill.ecse321.eventregistration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import ca.mcgill.ecse321.eventregistration.exception.EventRegistrationException;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.repository.PersonRepository;

@SpringBootTest
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class PersonServiceTests {
	@Mock
	private PersonRepository mockRepo;
	@InjectMocks
	private PersonService service;

	private static final String VALID_NAME = "Will";
	private static final String VALID_EMAIL = "will@aol.com";
	private static final String VALID_PASSWORD = "NotTim";

	@Test
	public void testCreateValidPerson() {
		// Arrange
		// Whenever mockRepo.save(p) is called, return p
		when(mockRepo.save(any(Person.class))).thenAnswer((InvocationOnMock iom) -> iom.getArgument(0));

		// Act
		Person createdPerson = service.createPerson(VALID_NAME, VALID_EMAIL, VALID_PASSWORD);

		// Assert
		assertNotNull(createdPerson);
		assertEquals(VALID_NAME, createdPerson.getName());
		assertEquals(VALID_EMAIL, createdPerson.getEmailAddress());
		assertEquals(VALID_PASSWORD, createdPerson.getPassword());
		assertEquals(Date.valueOf(LocalDate.now()), createdPerson.getCreationDate());
		// Check that mockRepo.save() was called exactly once and that the argument was
		// createdPerson
		verify(mockRepo, times(1)).save(createdPerson);
	}

	@Test
	public void testGetPersonByValidId() {
		// Arrange
		// Whenever mockRepo.findPersonById(42) is called, return a canned value
		Date today = Date.valueOf(LocalDate.now());
		when(mockRepo.findPersonById(42)).thenReturn(new Person(VALID_NAME, VALID_EMAIL, VALID_PASSWORD, today));

		// Act
		Person person = service.findPersonById(42);

		// Assert
		assertNotNull(person);
		assertEquals(VALID_NAME, person.getName());
		assertEquals(VALID_EMAIL, person.getEmailAddress());
		assertEquals(VALID_PASSWORD, person.getPassword());
		assertEquals(Date.valueOf(LocalDate.now()), person.getCreationDate());
	}

	@Test
	public void testGetPersonByInvalidId() {
		// Not even strictly required, since null is the default
		when(mockRepo.findPersonById(42)).thenReturn(null);

		EventRegistrationException ex = assertThrows(EventRegistrationException.class,
				() -> service.findPersonById(42));
		assertEquals(HttpStatus.NOT_FOUND, ex.getStatus());
		assertEquals("There is no person with ID 42.", ex.getMessage());
	}
}
