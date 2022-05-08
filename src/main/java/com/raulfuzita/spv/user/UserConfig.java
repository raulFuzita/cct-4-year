package com.raulfuzita.spv.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
		
	@Bean	
	CommandLineRunner commandLineRunner(UserRepository repository) {
		return args -> {
			
			User john = new User("John", "john@email.com", 
					"123", LocalDate.now(), UserRole.USER);
			User peter = new User("Peter", "peter@email.com", 
					"123", LocalDate.now(), UserRole.USER);
			
			repository.saveAll(List.of(john, peter));
		};
	}
}
