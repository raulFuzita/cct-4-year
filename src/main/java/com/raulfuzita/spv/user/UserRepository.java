package com.raulfuzita.spv.user;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	Optional<User> findUserByEmail(String email);
	
	@Transactional
    @Modifying
    @Query("UPDATE User u " +
            "SET u.enabled = TRUE WHERE u.email = ?1")
	int enableUser(String string);
}
