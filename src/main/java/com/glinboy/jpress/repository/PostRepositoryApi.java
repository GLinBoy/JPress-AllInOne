package com.glinboy.jpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jpress.model.Post;

public interface PostRepositoryApi extends JpaRepository<Post, Long> {

}
