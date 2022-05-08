package com.raulfuzita.spv.user;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
	)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDate birthday;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	private boolean locked = false;
	private boolean enabled = false;
	
	// If a property doesn't need in the database use @Transient notation
	
	public User() {}
	
	public User(long id, String name, String email, String password, 
			LocalDate birthday, UserRole userRole) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.userRole = userRole;
	}
	
	
	public User(String name, String email, String password, 
			LocalDate birthday, UserRole userRole) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.userRole = userRole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(authority);
	}

	@Override
	public String getUsername() {
		return name;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email 
				+ ", password=" + password + ", birthday="
				+ birthday + "]";
	}
	
}
