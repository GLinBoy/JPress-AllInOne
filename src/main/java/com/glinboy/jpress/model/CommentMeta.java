package com.glinboy.jpress.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
