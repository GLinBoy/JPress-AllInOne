package com.glinboy.jpress.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jpress.model.User;
import com.glinboy.jpress.service.UserServiceApi;

@RestController
@RequestMapping("/users")
public class UserController extends GenericController<User, UserServiceApi> {

	public UserController(UserServiceApi service) {
		super(service);
	}

}
