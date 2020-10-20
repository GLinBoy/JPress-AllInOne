package com.glinboy.jpress.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Post extends Auditable {

	private String postContent;

	private String postTitle;

	private String postExcerpt;

	@Enumerated(EnumType.STRING)
	private PostStatus postStatus;

	private Boolean commentStatus;

	private Boolean pingStatus;

	private String postPassword;

	private String postName;

	private String toPing;

	private String pinged;

	private String postContentFiltered;

	private UUID guid;

	private Integer menuOrder = 0;

	@Enumerated(EnumType.STRING)
	private PostType postType;

	private String postMimeType;

	private Long commentCount;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User postAuthor;

	@ManyToOne
	@JoinColumn(name = "post_parent_id")
	private Post postParent;

	@OneToMany(mappedBy = "postParent", cascade = CascadeType.ALL)
	private Set<Post> subPosts;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<Comment> comments;

	@ManyToMany
	@JoinTable(name = "term_relationship",
		joinColumns = @JoinColumn(name = "post_id"),
		inverseJoinColumns = @JoinColumn(name = "term_taxonomy_id"))
	private Set<TermTaxonomy> termRelationships;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PostMeta> postMetas;
}
