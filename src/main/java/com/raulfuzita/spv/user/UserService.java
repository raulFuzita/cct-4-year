package com.raulfuzita.spv.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> getUser() {
		return userRepository.findAll();
	}
}
