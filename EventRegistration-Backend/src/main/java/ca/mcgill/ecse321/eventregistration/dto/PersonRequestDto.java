package ca.mcgill.ecse321.eventregistration.dto;

public class PersonRequestDto {
	private String name;
	private String emailAddress;
	private String password;

	public PersonRequestDto(String name, String emailAddress, String password) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}
}
