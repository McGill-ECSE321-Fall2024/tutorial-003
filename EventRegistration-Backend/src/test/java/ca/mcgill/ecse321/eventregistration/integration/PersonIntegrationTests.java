package ca.mcgill.ecse321.eventregistration.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ca.mcgill.ecse321.eventregistration.dto.PersonRequestDto;
import ca.mcgill.ecse321.eventregistration.dto.PersonResponseDto;
import ca.mcgill.ecse321.eventregistration.repository.PersonRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PersonIntegrationTests {
	@Autowired
	private TestRestTemplate client;
	@Autowired
	private PersonRepository personRepo;

	private static final String VALID_NAME = "Tim";
	private static final String VALID_EMAIL = "tim@yahoo.com";
	private static final String VALID_PASSWORD = "abcde";
	private int personId;

	@AfterAll
	public void clearDatabase() {
		personRepo.deleteAll();
	}

	@Test
	@Order(1)
	public void testCreateValidPerson() {
		// Arrange
		PersonRequestDto tim = new PersonRequestDto(VALID_NAME, VALID_EMAIL, VALID_PASSWORD);

		// Act
		ResponseEntity<PersonResponseDto> response = client.postForEntity("/people", tim, PersonResponseDto.class);

		// Assert
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().getId() > 0, "The ID should be positive.");
		this.personId = response.getBody().getId();
		assertEquals(VALID_NAME, response.getBody().getName());
		assertEquals(VALID_EMAIL, response.getBody().getEmailAddress());
		LocalDate today = LocalDate.now();
		assertEquals(today, response.getBody().getCreationDate());
	}

	@Test
	@Order(2)
	public void testGetValidPersonById() {
		// Arrange
		String url = String.format("/people/%d", this.personId);

		System.out.println(String.format("URL: %s", url));

		// Act
		ResponseEntity<PersonResponseDto> response = client.getForEntity(url, PersonResponseDto.class);

		// Assert
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(this.personId, response.getBody().getId());
		assertEquals(VALID_NAME, response.getBody().getName());
		assertEquals(VALID_EMAIL, response.getBody().getEmailAddress());
		LocalDate today = LocalDate.now();
		assertEquals(today, response.getBody().getCreationDate());
	}
}
