package com.glinboy.jpress.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class UserMeta extends Meta {

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
