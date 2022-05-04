package com.raulfuzita.spv.registration;

public class RegistrationRequest {

	private final String name;
	private final String email;
	private final String password;
	private final String birthday;
	
	public RegistrationRequest(String name, String email, String password, String birthday) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
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
		return "RegistrationRequest [name=" + name + ", email=" + email 
				+ ", password=" + password + ", birthday="
				+ birthday + "]";
	}
	
	
	
}
