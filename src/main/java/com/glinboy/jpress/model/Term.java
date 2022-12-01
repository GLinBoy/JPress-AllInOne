package com.glinboy.jpress.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
