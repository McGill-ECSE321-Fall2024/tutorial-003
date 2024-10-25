package ca.mcgill.ecse321.eventregistration.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof InPersonEvent)) {
			return false;
		}
		InPersonEvent that = (InPersonEvent) obj;
		return super.equals(that) && this.address.equals(that.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.address);
	}
}
