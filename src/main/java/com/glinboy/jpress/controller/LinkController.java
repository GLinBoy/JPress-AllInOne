package com.glinboy.jpress.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jpress.model.Link;
import com.glinboy.jpress.service.LinkServiceApi;

@RestController
@RequestMapping("/links")
public class LinkController extends GenericController<Link, LinkServiceApi> {

	public LinkController(LinkServiceApi service) {
		super(service);
	}

}
