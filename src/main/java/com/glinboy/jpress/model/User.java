package com.glinboy.jpress.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class User extends BaseEntity {

	private String userLogin;
	private String userPass;
	private String userNicename;
	private String userEmail;
	private String userUrl;
	private LocalDateTime userRegistred;
	private String userActivationKey;
	private String displayName;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserMeta> userMetas;

	@OneToMany(mappedBy = "postAuthor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> posts;
	
	@OneToMany(mappedBy = "commentAuthor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "linkOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Link> links;
}
