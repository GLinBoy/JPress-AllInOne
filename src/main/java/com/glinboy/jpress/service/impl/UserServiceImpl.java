package com.glinboy.jpress.service.impl;

import com.glinboy.jpress.model.User;
import com.glinboy.jpress.repository.UserRepositoryApi;
import com.glinboy.jpress.service.UserServiceApi;

public class UserServiceImpl extends GenericServiceImpl<User, UserRepositoryApi>
	implements UserServiceApi {

	public UserServiceImpl(UserRepositoryApi repository) {
		super(repository);
	}

}
