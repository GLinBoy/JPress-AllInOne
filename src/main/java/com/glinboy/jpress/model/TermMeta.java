package com.glinboy.jpress.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class TermMeta extends Meta {

	@ManyToOne
	@JoinColumn(name = "term_id", nullable = false)
	private Term term;

}
