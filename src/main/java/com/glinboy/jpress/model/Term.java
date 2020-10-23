package com.glinboy.jpress.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(indexes = {
		@Index(name = "IND_NAME", columnList = "NAME")
	}, uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_SLUG", columnNames = "SLUG")
})
public class Term extends Auditable {

	@Column(length = 200)
	private String name;
	
	@Column(length = 200)
	private String slug;
	
	@Column(length = 10)
	private Long termGroup;
	
	@OneToMany(mappedBy = "term", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<TermMeta> termMetas;
	
	@OneToOne(mappedBy = "term", cascade = CascadeType.ALL, orphanRemoval = true)
	private TermTaxonomy termTaxonomy;

}
