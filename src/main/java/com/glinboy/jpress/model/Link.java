package com.glinboy.jpress.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Link extends Auditable {

	private String linkUrl;
	private String linkName;
	private String linkImage;
	private LinkTarget linkTarget;
	private String linkDescription;
	private Boolean linkVisible;
	private Integer linkRating;
	private String linkRel;
	private String linkNotes;
	private String linkRss;

	@ManyToOne
	@JoinColumn(name = "link_owner_id", nullable = false)
	private User linkOwner;
}
