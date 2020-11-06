package com.glinboy.jpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jpress.model.User;

public interface UserRepositoryApi extends JpaRepository<User, Long> {
	
	Optional<User> findByUserLogin(String userLoign);
	Optional<User> findByUserEmail(String userEmail);

}
