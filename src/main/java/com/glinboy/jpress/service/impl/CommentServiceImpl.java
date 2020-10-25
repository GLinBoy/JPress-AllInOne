package com.glinboy.jpress.service.impl;

import org.springframework.stereotype.Service;

import com.glinboy.jpress.model.Comment;
import com.glinboy.jpress.repository.CommentRepositoryApi;
import com.glinboy.jpress.service.CommentServiceApi;

@Service
public class CommentServiceImpl extends GenericServiceImpl<Comment, CommentRepositoryApi>
	implements CommentServiceApi{

	public CommentServiceImpl(CommentRepositoryApi repository) {
		super(repository);
	}

}
