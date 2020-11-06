package com.glinboy.jpress.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glinboy.jpress.model.Post;
import com.glinboy.jpress.service.PostServiceApi;

@Controller
public class HomeController {

	private final PostServiceApi postApi;
	
	
	public HomeController(PostServiceApi postApi) {
		this.postApi = postApi;
	}

	@RequestMapping(value = {"/", "/index", "index.html"})
	public String index(Model model, Pageable pageable) {
//		pageable = PageRequest.of(0, 10, Sort.by("createdOn").descending());
		Page<Post> page = postApi.getAll(pageable);
		model.addAttribute("page", page);
		return "index.html";
	}
	
	@RequestMapping(value = {"/about", "/about.html"})
	public String about() {
		return "about.html";
	}
	
	@RequestMapping(value = {"/contact", "/contact.html"})
	public String contact() {
		return "contact.html";
	}
	
	@RequestMapping(value = {"/post", "/post.html"})
	public String post() {
		return "post.html";
	}
	
	@RequestMapping(value = {"/login", "/login.html"})
	public String login() {
		return "login.html";
	}

}
