package com.glinboy.jpress.model;

import jakarta.persistence.Column;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Meta extends Auditable {

	@Column(name = "META_KEY", nullable = false)
	private String metaKey;

	@Column(name = "META_VALUE", nullable = false, columnDefinition = "text")
	private String metaValue;

}
