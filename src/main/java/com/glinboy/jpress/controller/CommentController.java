package com.glinboy.jpress.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jpress.model.Comment;
import com.glinboy.jpress.service.CommentServiceApi;

@RestController
@RequestMapping("/comments")
public class CommentController extends GenericController<Comment, CommentServiceApi> {

	public CommentController(CommentServiceApi service) {
		super(service);
	}

}
