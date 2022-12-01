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
		@Index(name = "IND_USER_ID", columnList = "USER_ID"),
		@Index(name = "IND_USER_META_KEY", columnList = "META_KEY")
})
public class UserMeta extends Meta {

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_META"))
	private User user;

}
