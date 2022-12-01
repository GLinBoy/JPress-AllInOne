package com.glinboy.jpress.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(indexes = {
		@Index(name = "IND_META_KEY", columnList = "META_KEY"),
		@Index(name = "IND_TERM_ID", columnList = "TERM_ID")
})
public class TermMeta extends Meta {

	@ManyToOne
	@JoinColumn(name = "TERM_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_TERM_META"))
	private Term term;

}
