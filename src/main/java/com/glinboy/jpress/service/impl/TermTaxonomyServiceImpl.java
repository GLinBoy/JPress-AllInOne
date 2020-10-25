package com.glinboy.jpress.service.impl;

import com.glinboy.jpress.model.TermTaxonomy;
import com.glinboy.jpress.repository.TermTaxonomyRepositoryApi;
import com.glinboy.jpress.service.TermTaxonomyServiceApi;

public class TermTaxonomyServiceImpl extends GenericServiceImpl<TermTaxonomy, TermTaxonomyRepositoryApi>
	implements TermTaxonomyServiceApi{

	public TermTaxonomyServiceImpl(TermTaxonomyRepositoryApi repository) {
		super(repository);
	}

}
