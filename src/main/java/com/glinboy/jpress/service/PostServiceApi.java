package com.glinboy.jpress.service;

import com.glinboy.jpress.model.Post;

public interface PostServiceApi extends GenericServiceApi<Post> {

	Post getPostByPostName(String postName);

}
