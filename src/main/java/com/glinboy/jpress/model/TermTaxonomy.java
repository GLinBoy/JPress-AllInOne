package com.glinboy.jpress.model;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class TermTaxonomy extends Auditable {

	private String taxonomy;
	private String description;
	private Long parent;
	private Long count;
	
	@OneToOne
	@MapsId
	private Term term;

}
