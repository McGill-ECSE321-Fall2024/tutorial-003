package ca.mcgill.ecse321.eventregistration.dto;

import java.util.List;

public class EventListDto {
    private List<EventResponseDto> events;

    public EventListDto(List<EventResponseDto> events) {
        this.events = events;
    }

    public List<EventResponseDto> getEvents() {
        return events;
    }

    public void setEvents(List<EventResponseDto> events) {
        this.events = events;
    }
}
