package com.raulfuzita.spv.registration;

public class RegistrationRequest {

	private final String firstName;
	private final String email;
	private final String password;
	private final String birthday;
	
	public RegistrationRequest(String firstName, String email, String password, String birthday) {
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getBirthday() {
		return birthday;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [firstName=" + firstName 
				+ ", email=" + email + ", password=" + password
				+ ", birthday=" + birthday + "]";
	}

	
}
