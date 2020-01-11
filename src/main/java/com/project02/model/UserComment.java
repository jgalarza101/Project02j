package com.project02.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "usercomment")
public class UserComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentid")
	private int commentid;
	@Column(name = "commentcontent")
	private String commentcontent;
	@Column(name = "commentdate")
	@Temporal(TemporalType.DATE)
	private Date commentdate;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
    @JoinColumn(name = "userid")
    private User user;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
    @JoinColumn(name = "postid")
    private Posts posts;

	public UserComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserComment(int commentid, String commentcontent, Date commentdate, User user, Posts posts) {
		super();
		this.commentid = commentid;
		this.commentcontent = commentcontent;
		this.commentdate = commentdate;
		this.user = user;
		this.posts = posts;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public Date getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

//	@ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	@ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "postid")
	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentcontent == null) ? 0 : commentcontent.hashCode());
		result = prime * result + ((commentdate == null) ? 0 : commentdate.hashCode());
		result = prime * result + commentid;
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserComment other = (UserComment) obj;
		if (commentcontent == null) {
			if (other.commentcontent != null)
				return false;
		} else if (!commentcontent.equals(other.commentcontent))
			return false;
		if (commentdate == null) {
			if (other.commentdate != null)
				return false;
		} else if (!commentdate.equals(other.commentdate))
			return false;
		if (commentid != other.commentid)
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserComment [commentid=" + commentid + ", commentcontent=" + commentcontent + ", commentdate="
				+ commentdate + ", user=" + user.getUserid() + ", posts=" + posts.getPostid() + "]";
	}
	
}
