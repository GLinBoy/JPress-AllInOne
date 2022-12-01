package com.glinboy.jpress.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
