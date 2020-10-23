package com.glinboy.jpress.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(
		uniqueConstraints = {
				@UniqueConstraint(name = "UNQ_COMMENT_META", columnNames = {"COMMENT_ID", "META_KEY"})
		},
		indexes = {
		@Index(name = "IND_COMMENT_META_KEY", columnList = "META_KEY")
})
public class CommentMeta extends Meta {

	@ManyToOne
	@JoinColumn(name = "COMMENT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_COMMENT_META"))
	private Comment comment;

}
