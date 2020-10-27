package com.glinboy.jpress.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jpress.model.TermTaxonomy;
import com.glinboy.jpress.service.TermTaxonomyServiceApi;

@RestController
@RequestMapping("/terms")
public class TermTaxonomyController extends GenericController<TermTaxonomy, TermTaxonomyServiceApi> {

	public TermTaxonomyController(TermTaxonomyServiceApi service) {
		super(service);
	}

}
