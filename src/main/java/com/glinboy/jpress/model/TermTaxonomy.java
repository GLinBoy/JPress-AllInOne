package com.glinboy.jpress.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
