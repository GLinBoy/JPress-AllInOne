package com.glinboy.jpress.service.impl;

import com.glinboy.jpress.model.Post;
import com.glinboy.jpress.repository.PostRepositoryApi;
import com.glinboy.jpress.service.PostServiceApi;

public class PostServiceImpl extends GenericServiceImpl<Post, PostRepositoryApi>
	implements PostServiceApi{

	public PostServiceImpl(PostRepositoryApi repository) {
		super(repository);
	}

}
