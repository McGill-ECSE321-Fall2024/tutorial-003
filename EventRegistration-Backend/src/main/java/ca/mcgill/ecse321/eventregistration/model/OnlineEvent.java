package ca.mcgill.ecse321.eventregistration.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class OnlineEvent extends Event {
	private String url;

	// Hibernate needs a no-args constructor, but it can be protected
	protected OnlineEvent() {
	}

	public OnlineEvent(String name, Date date, Time start, Time end, int registrationLimit, String url) {
		super(name, date, start, end, registrationLimit);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OnlineEvent)) {
			return false;
		}
		OnlineEvent that = (OnlineEvent) obj;
		return super.equals(that) && this.url.equals(that.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.url);
	}
}
