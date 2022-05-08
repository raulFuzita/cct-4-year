package com.raulfuzita.spv.registration.token;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.raulfuzita.spv.user.User;

@Entity
public class ConfirmationToken {

	@Id
	@SequenceGenerator(
			name = "confirmation_token_sequence",
			sequenceName = "confirmation_token_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "confirmation_token_sequence"
	)
	private long id;
	
	@Column(nullable = false)
	private String token;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@Column(nullable = false)
	private LocalDateTime expiredAt;
	
	private LocalDateTime confirmedAt;
	
	@ManyToOne
	@JoinColumn(
			nullable = false,
			name = "user_id"
	)
	private User user;
	
	public ConfirmationToken() {}

	public ConfirmationToken(long id, String token, LocalDateTime createdAt, LocalDateTime expiredAt,
			LocalDateTime confirmedAt, User user) {
		this.id = id;
		this.token = token;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
		this.confirmedAt = confirmedAt;
		this.user = user;
	}

	public ConfirmationToken(String token, LocalDateTime createdAt, 
			LocalDateTime expiredAt, User user) {
		this.token = token;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(LocalDateTime expiredAt) {
		this.expiredAt = expiredAt;
	}

	public LocalDateTime getConfirmedAt() {
		return confirmedAt;
	}

	public void setConfirmedAt(LocalDateTime confirmedAt) {
		this.confirmedAt = confirmedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ConfirmationToken [id=" + id + ", token=" + token 
				+ ", createdAt=" + createdAt + ", expiredAt="
				+ expiredAt + ", confirmedAt=" + confirmedAt + ", user=" + user + "]";
	}
	
	
}
