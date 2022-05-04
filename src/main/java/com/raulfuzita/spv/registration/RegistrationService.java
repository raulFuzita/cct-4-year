package com.raulfuzita.spv.registration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raulfuzita.spv.user.User;
import com.raulfuzita.spv.user.UserService;

@Service
public class RegistrationService {
	
	private final EmailValidator emailValidator;
	private final UserService useService;
	
	@Autowired
	public RegistrationService(EmailValidator emailValidator, UserService useService) {
		this.emailValidator = emailValidator;
		this.useService = useService;
	}



	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if (!isValidEmail) {
			throw new IllegalStateException("Email not valid");
		}
		
		LocalDate newBirthday = LocalDate.parse(request.getBirthday(), 
		DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return useService.signupUser(
				new User(
						request.getName(),
						request.getEmail(),
						request.getPassword(),
						newBirthday));
	}

}
