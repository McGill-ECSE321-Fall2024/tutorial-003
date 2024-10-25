package ca.mcgill.ecse321.eventregistration.dto;

import ca.mcgill.ecse321.eventregistration.model.OnlineEvent;

public class OnlineEventResponseDto extends EventResponseDto {
    private String url;

    public OnlineEventResponseDto(OnlineEvent event) {
        super(event);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
