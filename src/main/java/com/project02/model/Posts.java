package com.project02.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postid")
	private int postid;
	@Column(name = "posttitle")
	private String posttitle;
	@Column(name = "postcontent")
	private String postcontent;
	@Column(name = "postdate")
	@Temporal(TemporalType.DATE)
	private Date postdate;

	//@OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
	private Set<UserComment> userComments;
	//private Set<UserComment> userComments = new HashSet<UserComment>();
	
	@ManyToOne
	//@Column(name = "userid")
	@JoinColumn(name = "userid")
	private User user;

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Posts(int postid, String posttitle, String postcontent, Date postdate) {
		super();
		this.postid = postid;
		this.posttitle = posttitle;
		this.postcontent = postcontent;
		this.postdate = postdate;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

//	@OneToMany(mappedBy = "posts")
	public Set<UserComment> getUserComments() {
		return userComments;
	}

	public void setUserComments(Set<UserComment> comments) {
		this.userComments = comments;
	}
	
	public void addUserComment(UserComment userComment) {
		this.userComments.add(userComment);
	}
	
	
//	@OneToMany(mappedBy = "group")
//    public Set<UserGroup> getUserGroups() {
//        return userGroups;
//    }
// 
//    public void setUserGroups(Set<UserGroup> groups) {
//        this.userGroups = groups;
//    }
//     
//    public void addUserGroup(UserGroup userGroup) {
//        this.userGroups.add(userGroup);
//    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postcontent == null) ? 0 : postcontent.hashCode());
		result = prime * result + ((postdate == null) ? 0 : postdate.hashCode());
		result = prime * result + postid;
		result = prime * result + ((posttitle == null) ? 0 : posttitle.hashCode());
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
		Posts other = (Posts) obj;
		if (postcontent == null) {
			if (other.postcontent != null)
				return false;
		} else if (!postcontent.equals(other.postcontent))
			return false;
		if (postdate == null) {
			if (other.postdate != null)
				return false;
		} else if (!postdate.equals(other.postdate))
			return false;
		if (postid != other.postid)
			return false;
		if (posttitle == null) {
			if (other.posttitle != null)
				return false;
		} else if (!posttitle.equals(other.posttitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Posts [postid=" + postid + ", posttitle=" + posttitle + ", postcontent=" + postcontent + ", postdate="
				+ postdate + "]";
	}
	
}
