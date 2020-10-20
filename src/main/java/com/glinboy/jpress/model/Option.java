package com.glinboy.jpress.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Option extends Auditable {

	private String optionName;
	private String optionValue;
	private String autoload;

}
