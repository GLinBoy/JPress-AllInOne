package com.glinboy.jpress.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
