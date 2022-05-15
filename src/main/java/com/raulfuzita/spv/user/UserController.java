package com.raulfuzita.spv.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://127.0.0.1:8080")
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping
	public void registerUser(@RequestBody User user) {
		userService.addNewUser(user);
	}
	
	@DeleteMapping(path = "{userId}")
	public void deleteUser(@PathVariable("userId") long userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping(path  = "{userId}")
	public void updateUser(
			@PathVariable("userId") long userId,
			@RequestParam(required = false) String birthday) {
		userService.updateUser(userId, birthday);
	}
}
