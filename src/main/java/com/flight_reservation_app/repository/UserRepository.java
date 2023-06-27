package com.flight_reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flight_reservation_app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query()
	User findByEmail(String email);

	
}
