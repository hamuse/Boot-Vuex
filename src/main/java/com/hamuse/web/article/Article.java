package com.hamuse.web.article;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.hamuse.web.person.Person;
import com.hamuse.web.proxy.Proxy;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Table(name="ARTICLE")
public class Article extends Proxy implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ARTICLEID")  @NotNull
	private String articleid;
	@Column(name="IMAGE")
	private Long image;
	@Column(name="USERID")  @NotNull
	private String userid;
	@Column(name="COMMENTS") 
	private String comments;
	@Column(name="DM")  
	private String dm;
	@Column(name="RATING")
	private String rating;
	@Column(name="BOARDTYPE") @NotNull 
	private String boardtype;
	@Column(name="TITLE") @NotNull 
	private String title;
	@Column(name="CONTENT")  @NotNull
	private String content;
	@Temporal(TemporalType.DATE)
	@Column(name="REGDATE") @NotNull 
	private Date regdate;
	
	  @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "personid")
	  private Person personid;
	
	@Builder
		private Article(Long image, @NotNull String userid, String comments, String dm, String rating,
			@NotNull String boardtype, @NotNull String title, @NotNull String content, @NotNull Date regdate) {
		Assert.hasText(string(image),"image" );
		Assert.hasText(userid,"userid must not be null" );
		Assert.hasText(comments, "comments");
		Assert.hasText(dm,"dm");
		Assert.hasText(rating, "rating");
		Assert.hasText(boardtype, "boardtype must not be null");
		Assert.hasText(title,"title must not be null" );
		Assert.hasText(content, "content must not be null");
		Assert.hasText(string(regdate),"regdate must not be null" );
		this.image = image;
		this.userid = userid;
		this.comments = comments;
		this.dm = dm;
		this.rating = rating;
		this.boardtype = boardtype;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}


	
}
