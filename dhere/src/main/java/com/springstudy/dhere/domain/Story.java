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
	private String profile; // Member domain의 picture
	private int imageNo;
	private String fileName;
	
	
	public Story() {}
	
	public Story(int storyNo, String title, String content, String email, Timestamp regDate, int categoryNo, 
			int readCount, int thank, String nickname, int imageNo, String fileName) {
		
	    this.storyNo = storyNo;
	    this.title = title;
	    this.content = content;
	    this.email = email;
	    this.regDate = regDate;
	    this.categoryNo = categoryNo;
	    this.readCount = readCount;
	    this.thank = thank;
	    this.nickname = nickname;
	    this.imageNo = imageNo;
	    this.fileName = fileName;
	}

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

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
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

	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
