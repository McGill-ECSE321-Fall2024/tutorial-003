package ca.mcgill.ecse321.eventregistration.dto;

import ca.mcgill.ecse321.eventregistration.model.InPersonEvent;

public class InPersonEventResponseDto extends EventResponseDto {
    private String address;

    public InPersonEventResponseDto(InPersonEvent event, int numRegistered) {
        super(event, numRegistered);
        this.address = event.getAddress();
    }

    @Override
    public EventType getType() {
        return EventType.IN_PERSON;
    }

    public String getAddress() {
        return address;
    }
}
