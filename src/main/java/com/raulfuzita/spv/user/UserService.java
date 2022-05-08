package com.raulfuzita.spv.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raulfuzita.spv.registration.token.ConfirmationToken;
import com.raulfuzita.spv.registration.token.ConfirmationTokenService;

@Service
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	private final String USER_NOT_FOUND_MSG = "User with email %s not found";
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			ConfirmationTokenService confirmationTokenService) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.confirmationTokenService = confirmationTokenService;
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
	
	public String signupUser(User user) {
		boolean userExists = userRepository
				.findUserByEmail(user.getEmail())
				.isPresent();
		
		if (userExists) {
			throw new IllegalStateException("Email already taken");
		}
		
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		
		String token = UUID.randomUUID().toString();
		
		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				user
		);
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		
		// TODO: Send email
		
		return token;
	}
	
	public int enableUser(String email) {
		return userRepository.enableUser(email);
	}
}
