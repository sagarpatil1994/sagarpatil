package com.niit.chatappbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component

public class Forum {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;


private String forumtitle;

private String forumcontent;

private Date forumdate;

private String forumusername;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getForumtitle() {
	return forumtitle;
}

public void setForumtitle(String forumtitle) {
	this.forumtitle = forumtitle;
}

public String getForumcontent() {
	return forumcontent;
}

public void setForumcontent(String forumcontent) {
	this.forumcontent = forumcontent;
}

public Date getForumdate() {
	return forumdate;
}

public void setForumdate(Date forumdate) {
	this.forumdate = forumdate;
}

public String getForumusername() {
	return forumusername;
}

public void setForumusername(String forumusername) {
	this.forumusername = forumusername;
} 




}
