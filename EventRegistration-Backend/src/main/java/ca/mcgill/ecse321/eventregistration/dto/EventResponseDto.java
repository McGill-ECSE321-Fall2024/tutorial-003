package ca.mcgill.ecse321.eventregistration.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.InPersonEvent;
import ca.mcgill.ecse321.eventregistration.model.OnlineEvent;

public abstract class EventResponseDto {
    private int id;
    private EventType type;
    private String name;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int registrationLimit;

    public EventResponseDto(OnlineEvent event) {
        this.id = event.getId();
        this.type = EventType.ONLINE;
        this.name = event.getName();
        this.date = event.getDate().toLocalDate();
        this.startTime = event.getStartTime().toLocalTime();
        this.endTime = event.getEndTime().toLocalTime();
        this.registrationLimit = event.getRegistrationLimit();
    }

    public EventResponseDto(InPersonEvent event) {
        this.id = event.getId();
        this.type = EventType.IN_PERSON;
        this.name = event.getName();
        this.date = event.getDate().toLocalDate();
        this.startTime = event.getStartTime().toLocalTime();
        this.endTime = event.getEndTime().toLocalTime();
        this.registrationLimit = event.getRegistrationLimit();
    }

    public static EventResponseDto create(Event event) {
        // Normally you'd want to have a method like toDto() on the model class so you
        // don't need to do this instanceof nonsense. But in a layered architecture, we
        // don't want a layer (in this case, the models) to depend on a higher layer (in
        // this case, the DTOs).
        if (event instanceof OnlineEvent) {
            return new OnlineEventResponseDto((OnlineEvent) event);
        } else if (event instanceof InPersonEvent) {
            return new InPersonEventResponseDto((InPersonEvent) event);
        } else {
            throw new IllegalArgumentException("Unknown event type.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getRegistrationLimit() {
        return registrationLimit;
    }

    public void setRegistrationLimit(Integer registrationLimit) {
        this.registrationLimit = registrationLimit;
    }
}
