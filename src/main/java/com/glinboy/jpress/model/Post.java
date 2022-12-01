package com.glinboy.jpress.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(indexes = {
		@Index(name = "IND_POST_NAME", columnList = "POST_NAME"),
		@Index(name = "IND_POST", columnList = "POST_TYPE,POST_STATUS,CREATED_ON,ID"),
		@Index(name = "IND_USER", columnList = "USER_ID")
})
public class Post extends Auditable {

	@Column(columnDefinition = "text")
	private String postContent;

	@Column(columnDefinition = "text")
	private String postTitle;

	@Column(columnDefinition = "text")
	private String postExcerpt;

	@Enumerated(EnumType.STRING)
	@Column(name = "POST_STATUS")
	private PostStatus postStatus;

	private Boolean commentStatus;

	private Boolean pingStatus;

	private String postPassword;

	@Column(name = "POST_NAME")
	private String postName;

	@Column(columnDefinition = "text")
	private String toPing;

	@Column(columnDefinition = "text")
	private String pinged;

	@Column(columnDefinition = "text")
	private String postContentFiltered;

	private Integer menuOrder = 0;

	@Enumerated(EnumType.STRING)
	@Column(name = "POST_TYPE")
	private PostType postType;

	@Column(length = 100)
	private String postMimeType;

	private Long commentCount;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_POST"))
	private User postAuthor;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<Comment> comments;

	@ManyToMany
	@JoinTable(name = "TERM_RELATIONSHIP",
		joinColumns = @JoinColumn(name = "POST_ID", foreignKey = @ForeignKey(name = "FK_POST_RELATIONSHIP")),
		inverseJoinColumns = @JoinColumn(name = "TERM_TAXONOMY_ID", foreignKey = @ForeignKey(name = "FK_TAXONOMY_RELATIONSHIP")))
	private Set<TermTaxonomy> termRelationships;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PostMeta> postMetas;
}
