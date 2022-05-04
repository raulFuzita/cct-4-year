package com.raulfuzita.spv.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public ResponseEntity<String> addNewUser(User user) {
		Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
		if (userOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		userRepository.save(user);
		return ResponseEntity.ok("User register successfully");
	}

	public void deleteUser(long userId) {
		boolean exists = userRepository.existsById(userId);
		if (!exists) {
			throw new IllegalStateException(
					String.format("User with id %o doesn't exist", userId));
		}
		userRepository.deleteById(userId);
	}

	@Transactional
	public void updateUser(long userId, String birthday) {
		
		try {
			LocalDate newBirthday = LocalDate.parse(birthday, 
					DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.println(birthday);
			User user = userRepository.findById(userId)
					.orElseThrow(()-> new IllegalStateException(
							String.format("User with id %o does not exist", userId)));
			user.setBirthday(newBirthday);
		} catch (Exception e) {
			new IllegalStateException(
					String.format("Date format invalid %s. Expected yyyy-MM-dd", birthday));
		}
		
	}

	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		
		return userRepository.findUserByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException(
						String.format(USER_NOT_FOUND_MSG, email)));
	}
}
