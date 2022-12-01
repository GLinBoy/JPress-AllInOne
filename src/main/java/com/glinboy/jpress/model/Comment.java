package com.glinboy.jpress.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(indexes = {
		@Index(name = "IND_comment_STATUS", columnList = "STATUS"),
		@Index(name = "IND_COMMENT_DATE", columnList = "CREATED_ON"),
		@Index(name = "IND_COMMENT_PARENT", columnList = "PARENT_COMMENT_ID"),
		@Index(name = "IND_AUTHOR_EMAIL", columnList = "COMMENT_AUTHOR_EMAIL")
})
// TODO Decide about how to manage audit on comments
public class Comment extends Auditable {

	@Column(columnDefinition = "text")
	private String commentAuthor;
	
	@Column(name = "COMMENT_AUTHOR_EMAIL", length = 100)
	private String commentAuthorEmail;
	
	@Column(length = 200)
	private String commentAuthorUrl;
	
	@Column(length = 100)
	private String commentAuthorIp;
	
	@Column(columnDefinition = "text")
	private String commentContent;
	
	private Integer commentKarma;
	
	private CommentStatus Status = CommentStatus.HOLD;
	
	private String commentAgent;
	
	private CommentType commentType = CommentType.COMMENT;
	
	@ManyToOne
	@JoinColumn(name = "COMMENT_USER_ID", foreignKey = @ForeignKey(name = "FK_USER_COMMENT"))
	private User user;

	@ManyToOne
	@JoinColumn(name = "POST_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_POST_USER"))
	private Post post;
	
	@OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CommentMeta> commentMetas;
	
	@OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_COMMENT_ID", foreignKey = @ForeignKey(name = "FK_PARENT_COMMENT"))
	private Comment parentComment;
}
