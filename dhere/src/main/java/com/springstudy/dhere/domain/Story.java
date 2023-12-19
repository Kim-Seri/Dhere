package com.springstudy.dhere.domain;

import java.sql.Timestamp;
import java.util.List;

public class Story {
	
	private int storyNo;
	private String title;
	private String content;
	private String email;
	private Timestamp regDate;
	private int categoryNo;
	private int readCount;
	private int thank;
	private String nickname;
	private String thumbnail; // Image domain의 file_name
	private String profile; // Member domain의 picture
	
	public Story() {}


	public int getStoryNo() {
		return storyNo;
	}


	public void setStoryNo(int storyNo) {
		this.storyNo = storyNo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Timestamp getRegDate() {
		return regDate;
	}


	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}


	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int cateforyNo) {
		this.categoryNo = cateforyNo;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}


	public int getThank() {
		return thank;
	}


	public void setThank(int thank) {
		this.thank = thank;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	
}
