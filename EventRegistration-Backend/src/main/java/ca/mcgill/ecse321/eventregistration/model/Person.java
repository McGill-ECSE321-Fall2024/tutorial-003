package ca.mcgill.ecse321.eventregistration.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String emailAddress;
	private String password;
	private Date creationDate;

	// Hibernate needs a no-args constructor, but it can be protected
	protected Person() {
	}

	public Person(String name, String emailAddress, String password, Date creationDate) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.creationDate = creationDate;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}
