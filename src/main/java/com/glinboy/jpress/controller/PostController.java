package com.glinboy.jpress.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glinboy.jpress.model.Post;
import com.glinboy.jpress.service.PostServiceApi;

@Controller
public class PostController {

	private final PostServiceApi postApi;

	public PostController(PostServiceApi postApi) {
		this.postApi = postApi;
	}

	@RequestMapping("/posts")
	public String getAllPosts(Pageable pageable, Model model) {
		Page<Post> page = postApi.getAll(pageable);
		model.addAttribute("page", page);
		return "index.html";
	}
	
	@RequestMapping("/posts/{post_name}")
	public String getAllPosts(Model model, @PathVariable("post_name") String postName) {
		Post post = postApi.getPostByPostName(postName);
		model.addAttribute("post", post);
		return "post.html";
	}
}
