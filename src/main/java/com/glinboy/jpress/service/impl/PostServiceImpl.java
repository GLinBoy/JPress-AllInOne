package com.glinboy.jpress.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.glinboy.jpress.model.Post;
import com.glinboy.jpress.repository.PostRepositoryApi;
import com.glinboy.jpress.service.PostServiceApi;

@Service
public class PostServiceImpl extends GenericServiceImpl<Post, PostRepositoryApi>
	implements PostServiceApi{

	public PostServiceImpl(PostRepositoryApi repository) {
		super(repository);
	}

	@Override
	public Post getPostByPostName(String postName) {
		Post post = this.repository.findOneByPostName(postName)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
					this.messages.getString("post.not.found.name").concat(postName)));
		return post;
	}

}
