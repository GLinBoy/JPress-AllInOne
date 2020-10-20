package com.glinboy.jpress.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class Meta extends Auditable {

	private String metaKey;
	private String metaValue;

}
