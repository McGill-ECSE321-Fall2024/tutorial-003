package ca.mcgill.ecse321.eventregistration.dto;

import java.time.LocalDate;

import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.OnlineEvent;

public class EventSummaryDto {
	private int id;
	private String name;
	private EventType type;
	private LocalDate date;

	public EventSummaryDto(Event event) {
		this.id = event.getId();
		this.name = event.getName();
		this.type = event instanceof OnlineEvent ? EventType.ONLINE : EventType.IN_PERSON;
		this.date = event.getDate().toLocalDate();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public EventType getType() {
		return type;
	}

	public LocalDate getDate() {
		return date;
	}
}
