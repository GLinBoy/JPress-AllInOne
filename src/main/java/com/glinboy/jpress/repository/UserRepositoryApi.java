package com.glinboy.jpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jpress.model.User;

public interface UserRepositoryApi extends JpaRepository<User, Long> {

}
