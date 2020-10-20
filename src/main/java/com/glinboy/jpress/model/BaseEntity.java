package com.glinboy.jpress.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@MappedSuperclass
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;
}
