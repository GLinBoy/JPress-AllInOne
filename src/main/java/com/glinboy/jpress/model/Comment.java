package com.glinboy.jpress.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
// TODO Decide about how to manage audit on comments
public class Comment extends Auditable {

	private String commentAuthor;
	private String commentAuthorEmail;
	private String commentAuthorUrl;
	private String commentAuthorIp;
	private String commentContent;
	private Integer commentKarma;
	private CommentStatus Status = CommentStatus.HOLD;
	private String commentAgent;
	private CommentType commentType = CommentType.COMMENT;
	
	@ManyToOne
	@JoinColumn(name = "comment_authoer_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;
	
	@OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CommentMeta> commentMetas;
	
	@OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "parent_comment_id")
	private Comment parentComment;
}
