package com.raulfuzita.spv.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUser() {
		return userService.getUser();
	}
}
