package com.glinboy.jpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = {"/", "/index", "index.html"})
	public String index() {
		return "index.html";
	}
	
	@RequestMapping(value = {"/about", "about.html"})
	public String about() {
		return "about.html";
	}
	
	@RequestMapping(value = {"/contact", "contact.html"})
	public String contact() {
		return "contact.html";
	}
	
	@RequestMapping(value = {"/post", "post.html"})
	public String post() {
		return "post.html";
	}

}
