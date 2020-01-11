package com.project02.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name = "userinfo")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userid;
	@Column(name = "username", unique = true)
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "fullname")
	private String fullname;
	@Column(name = "aboutme")
	private String aboutme;

	// @OneToMany(mappedBy = "userinfo", cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserComment> userComments;
	//private Set<UserComment> userComments = new HashSet<UserComment>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userid, String username, String password, String fullname, String aboutme) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.aboutme = aboutme;
	}

	// Needed to update usercomments table
	public void addComment(UserComment ucomment) {
		this.userComments.add(ucomment);
	}
	// End of new code 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutme == null) ? 0 : aboutme.hashCode());
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (aboutme == null) {
			if (other.aboutme != null)
				return false;
		} else if (!aboutme.equals(other.aboutme))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userid != other.userid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	// New code needed to map to usercomments without a composite key
	//@OneToMany(mappedBy = "user")
	public Set<UserComment> getUserComments() {
		return userComments;
	}

	public void setUserComments(Set<UserComment> comments) {
		this.userComments = comments;
	}

	public void addUserComment(UserComment userComment) {
		this.userComments.add(userComment);
	}
	// end of new code

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", aboutme=" + aboutme + "]";
	}
}