package com.glinboy.jpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

	@RequestMapping(value = {"/", "/index", "index.html"})
	public String admin() {
		return "admin";
	}
}
