package ca.mcgill.ecse321.eventregistration.dto;

public class PersonRequestDto {
    private String name;
    private String emailAddress;
    private String password;

    public PersonRequestDto(String name, String email, String password) {
        this.name = name;
        this.emailAddress = email;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
