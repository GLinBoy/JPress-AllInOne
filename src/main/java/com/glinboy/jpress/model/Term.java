package com.glinboy.jpress.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Term extends Auditable {

	private String name;
	private String slug;
	private Long termGroup;
	
	@OneToMany(mappedBy = "term", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<TermMeta> termMetas;
	
	@OneToOne(mappedBy = "term", cascade = CascadeType.ALL, orphanRemoval = true)
	private TermTaxonomy termTaxonomy;

}
