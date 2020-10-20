package com.glinboy.jpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jpress.model.Comment;

public interface CommentRepositoryApi extends JpaRepository<Comment, Long> {

}
