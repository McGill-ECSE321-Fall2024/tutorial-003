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

	// Hibernate requires a default constructor, but it doesn't need to be public
	// https://docs.jboss.org/hibernate/orm/6.5/userguide/html_single/Hibernate_User_Guide.html#entity-pojo
	protected Person() {
		super();
	}

	public Person(String name, String emailAddress, String password, Date creationDate) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}
