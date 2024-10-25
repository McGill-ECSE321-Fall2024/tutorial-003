package ca.mcgill.ecse321.eventregistration.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Event {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private Date date;
	private Time startTime;
	private Time endTime;
	private int registrationLimit;

	// Hibernate needs a no-args constructor, but it can be protected
	protected Event() {
	}

	public Event(String name, Date date, Time start, Time end, int registrationLimit) {
		this.name = name;
		this.date = date;
		this.startTime = start;
		this.endTime = end;
		this.registrationLimit = registrationLimit;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public int getRegistrationLimit() {
		return registrationLimit;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Event)) {
			return false;
		}
		Event that = (Event) obj;
		return this.id == that.id
				&& this.name.equals(that.name)
				&& this.date.equals(that.date)
				&& this.startTime.equals(that.startTime)
				&& this.endTime.equals(that.endTime)
				&& this.registrationLimit == that.registrationLimit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				this.id,
				this.name,
				this.date,
				this.startTime,
				this.endTime,
				this.registrationLimit);
	}
}
