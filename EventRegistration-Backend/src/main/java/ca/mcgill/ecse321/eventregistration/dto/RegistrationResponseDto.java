package ca.mcgill.ecse321.eventregistration.dto;

import ca.mcgill.ecse321.eventregistration.model.Registration;

public class RegistrationResponseDto {
    private PersonResponseDto person;
    private EventResponseDto event;

    public RegistrationResponseDto(Registration registration) {
        this.person = new PersonResponseDto(registration.getKey().getRegistrant());
        this.event = EventResponseDto.create(registration.getKey().getEvent());
    }

    public EventResponseDto getEvent() {
        return event;
    }

    public void setEvent(EventResponseDto event) {
        this.event = event;
    }

    public PersonResponseDto getPerson() {
        return person;
    }

    public void setPerson(PersonResponseDto person) {
        this.person = person;
    }
}
