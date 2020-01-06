package com.hamuse.web.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.hamuse.web.article.Article;
import com.hamuse.web.proxy.Proxy;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter(value = AccessLevel.PROTECTED)
@ToString
@Table(name="PERSON",
uniqueConstraints={
		@UniqueConstraint(columnNames={"USERID"})})


public class Person extends Proxy  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // 전략 패턴  Box<T> 이런느낌으로 사용할수 있다.
	@Column(name="PERSONID") @NotNull
	private Long personid;
	@Column(name="USERID") @NotNull 
	private String userid;
	@Column(name="PASSWD") @NotNull
	private String passwd;
	@Column(name="NAME") @NotNull 
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDAY") @NotNull 
	private Date birthday;
	@Column(name="MALE") @NotNull
	private boolean male;
	@Column(name = "HAK") @NotNull
	private int hak;
	@Column(name = "BAN") @NotNull
	private int ban;
	@Column(name = "SCORE") @NotNull
	private int score;
	@Column(name = "Role") @NotNull
	private String role;
	enum Level{HIGH, MID, LOW}
	
	 @OneToMany(mappedBy = "personid",cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Article> articles = new ArrayList<>();
	
	@Builder
	private Person(@NotNull String userid, @NotNull String passwd, @NotNull String name, @NotNull Date birthday,
			@NotNull boolean male, @NotNull int hak, @NotNull int ban, @NotNull int score, @NotNull String role) {
		 Assert.hasText(userid, "userid must not be null");
		 Assert.hasText(passwd, "passwd must not be null");
		 Assert.hasText(name, "name must not be empty");
		 Assert.hasText(string(birthday), "birthday must not be empty");
		 Assert.hasText(string(male), "male must not be empty");
		 Assert.hasText(string(hak), "hak must not be empty");
		 Assert.hasText(string(ban), "ban must not be empty");
		 Assert.hasText(string(score), "score must not be empty");
		 Assert.hasText(string(role), "role must not be empty");
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.birthday = birthday;
		this.male = male;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
		this.role = role;
	}


	
	
}
