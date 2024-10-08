package ca.mcgill.ecse321.eventregistration.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;

@Entity
public class InPersonEvent extends Event {
	private String address;

	// Hibernate needs a no-args constructor, but it can be protected
	protected InPersonEvent() {
	}

	public InPersonEvent(String name, Date date, Time start, Time end, int registrationLimit, String address) {
		super(name, date, start, end, registrationLimit);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}
