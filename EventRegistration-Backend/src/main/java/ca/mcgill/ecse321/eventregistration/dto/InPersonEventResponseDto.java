package ca.mcgill.ecse321.eventregistration.dto;

import ca.mcgill.ecse321.eventregistration.model.InPersonEvent;

public class InPersonEventResponseDto extends EventResponseDto {
    private String address;

    public InPersonEventResponseDto(InPersonEvent event) {
        super(event);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
