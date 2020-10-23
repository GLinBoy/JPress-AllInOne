package com.glinboy.jpress.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_TERM_ID", columnNames = "TERM_ID")
}, indexes = {
		@Index(name = "IND_TAXONOMY", columnList = "TAXONOMY")
})
public class TermTaxonomy extends Auditable {

	@Column(name = "TAXONOMY", length = 32)
	private String taxonomy;
	
	private String description;
	
	private Long count;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "TERM_ID", foreignKey = @ForeignKey(name = "FK_TERM_TAXONOMY"))
	private Term term;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_TAXONOMY_ID", foreignKey = @ForeignKey(name = "FK_PARENT_TAXONOMY"))
	private TermTaxonomy parentTaxonomy;
	
	@OneToMany(mappedBy = "parentTaxonomy", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<TermTaxonomy> termTaxonomies;

}
