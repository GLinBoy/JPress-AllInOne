package com.glinboy.jpress.service.impl;

import org.springframework.stereotype.Service;

import com.glinboy.jpress.model.Link;
import com.glinboy.jpress.repository.LinkRepositoryApi;
import com.glinboy.jpress.service.LinkServiceApi;

@Service
public class LinkServiceImpl extends GenericServiceImpl<Link, LinkRepositoryApi>
	implements LinkServiceApi{

	public LinkServiceImpl(LinkRepositoryApi repository) {
		super(repository);
	}

}
