package com.glinboy.jpress.service.impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.glinboy.jpress.model.User;
import com.glinboy.jpress.model.UserPrincipal;
import com.glinboy.jpress.repository.UserRepositoryApi;
import com.glinboy.jpress.service.UserServiceApi;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserRepositoryApi> implements UserServiceApi {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepositoryApi repository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super(repository);
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public Optional<User> findUserByUsername(String username) {
		return this.repository.findByUserLogin(username);
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		return this.repository.findByUserEmail(email);
	}
	
	@Override
	public User save(User user) {
		user.setUserPass(bCryptPasswordEncoder.encode(user.getUserPass()));
		return super.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findUserByUsername(username).orElseThrow(() -> 
			new UsernameNotFoundException(messages.getString("user.error.not.found").concat(username)));
		return new UserPrincipal(user);
	}

}
