package ca.mcgill.ecse321.eventregistration.dto;

import java.time.LocalDate;

import ca.mcgill.ecse321.eventregistration.model.Person;

public class PersonResponseDto {
    private int id;
    private String name;
    private String emailAddress;
    private LocalDate creationDate;

    // Jackson needs a default constructor, but it doesn't need to be public
    @SuppressWarnings("unused")
    private PersonResponseDto() {
    }

    public PersonResponseDto(Person model) {
        this.id = model.getId();
        this.name = model.getName();
        this.emailAddress = model.getEmailAddress();
        this.creationDate = model.getCreationDate().toLocalDate();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
