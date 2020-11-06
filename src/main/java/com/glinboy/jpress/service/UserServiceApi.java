package com.glinboy.jpress.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.glinboy.jpress.model.User;

public interface UserServiceApi extends GenericServiceApi<User>, UserDetailsService {
	
	Optional<User> findUserByUsername(String username);
	Optional<User> findUserByEmail(String email);

}
