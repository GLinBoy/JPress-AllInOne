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
		@Index(name = "IND_POST_META_KEY", columnList = "META_KEY"),
		@Index(name = "IND_POST_ID", columnList = "POST_ID")
})
public class PostMeta extends Meta {

	@ManyToOne
	@JoinColumn(name = "POST_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_POST_META"))
	private Post post;

}
