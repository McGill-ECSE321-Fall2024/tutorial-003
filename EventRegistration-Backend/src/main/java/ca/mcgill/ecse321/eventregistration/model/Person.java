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
	private Date creationDate;

	public Person(String name, String emailAddress, Date creationDate) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.creationDate = creationDate;
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

	public Date getCreationDate() {
		return creationDate;
	}
}
