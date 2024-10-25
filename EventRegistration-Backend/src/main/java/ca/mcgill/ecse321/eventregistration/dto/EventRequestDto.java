package ca.mcgill.ecse321.eventregistration.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventRequestDto {
    private EventType type;
    private String name;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int registrationLimit;
    private String address;
    private String url;

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

    public int getRegistrationLimit() {
        return registrationLimit;
    }

    public void setRegistrationLimit(int registrationLimit) {
        this.registrationLimit = registrationLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
