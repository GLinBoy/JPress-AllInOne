package com.glinboy.jpress.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(indexes = {
		@Index(name = "IND_LINK_VISIBLE", columnList = "LINK_VISIBLE")
})
public class Link extends Auditable {

	private String linkUrl;
	
	private String linkName;
	
	private String linkImage;
	
	@Enumerated(EnumType.STRING)
	private LinkTarget linkTarget;
	
	private String linkDescription;
	
	@Column(name = "LINK_VISIBLE")
	private Boolean linkVisible;
	
	private Integer linkRating;
	
	private String linkRel;
	
	@Column(columnDefinition = "text")
	private String linkNotes;
	
	private String linkRss;

	@ManyToOne
	@JoinColumn(name = "LINK_OWNER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_LINK"))
	private User linkOwner;
}
