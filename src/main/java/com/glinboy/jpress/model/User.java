package com.glinboy.jpress.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(indexes = {
		@Index(name = "IND_USER_LOGIN", columnList = "USER_LOGIN", unique = true),
		@Index(name = "IND_USER_NICENAME", columnList = "USER_NICENAME", unique = true)
})
public class User extends BaseEntity {

	@Column(name = "USER_LOGIN", length = 60)
	private String userLogin;
	
	@Column(length = 128)
	private String userPass;
	
	@Column(name = "USER_NICENAME", length = 50)
	private String userNicename;
	
	@Column(length = 100)
	private String userEmail;
	
	@Column(length = 100)
	private String userUrl;
	
	private LocalDateTime userRegistred;
	
	@Column(length = 60)
	private String userActivationKey;
	
	@Column(length = 250)
	private String displayName;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserMeta> userMetas;

	@OneToMany(mappedBy = "postAuthor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> posts;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "linkOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Link> links;
}
