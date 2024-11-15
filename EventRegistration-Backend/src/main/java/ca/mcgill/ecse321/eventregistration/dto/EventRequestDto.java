package ca.mcgill.ecse321.eventregistration.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EventRequestDto {
    @NotNull(message = "Event type is required.")
    private EventType type;
    @NotBlank(message = "Event name is required.")
    private String name;
    @NotNull(message = "Event date is required.")
    private LocalDate date;
    @NotNull(message = "Event start time is required.")
    private LocalTime startTime;
    private LocalTime endTime;
    @Min(value = 0, message = "The registration limit must be non-negative.")
    private int registrationLimit;
    @NotBlank(message = "Event location is required.")
    private String location;

    public EventType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getRegistrationLimit() {
        return registrationLimit;
    }

    public String getLocation() {
        return location;
    }
}
