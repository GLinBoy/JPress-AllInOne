package com.glinboy.jpress.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glinboy.jpress.model.Post;
import com.glinboy.jpress.model.User;
import com.glinboy.jpress.service.PostServiceApi;
import com.glinboy.jpress.util.CommonUtils;

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
	
	@RequestMapping("/admin/posts/new")
	public String newPosts(Model model) {
		model.addAttribute("post", new Post());
		return "new-post.html";
	}
	
	@RequestMapping(path = "/admin/posts", method = RequestMethod.POST)
	public String newPosts(Model model, Post post) {
		User u = new User();
		u.setId(1L);
		post.setPostAuthor(u);
		post.setIsActive(true);
		post.setPostName(CommonUtils.ClacSlug(post.getPostTitle()));
		postApi.save(post);
		Page<Post> page = postApi.getAll(PageRequest.of(0, 20, Sort.by("createdOn").descending()));
		model.addAttribute("page", page);
		return "admin-posts.html";
	}
	
	@RequestMapping("/admin/posts")
	public String getAllPostsForAdmin(Model model, Pageable pageable) {
		Page<Post> page = postApi.getAll(pageable);
		model.addAttribute("page", page);
		return "admin-posts.html";
	}
}
