package com.glinboy.jpress.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_OPTION_NAME", columnNames = "OPTION_NAME")
})
public class Option extends Auditable {

	@Column(name = "OPTION_NAME", length = 64)
	private String optionName;
	
	@Column(columnDefinition = "text")
	private String optionValue;
	
	private Boolean autoload;

}
