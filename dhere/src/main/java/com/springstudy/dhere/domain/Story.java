package com.springstudy.dhere.domain;

import java.sql.Timestamp;
import java.util.List;

public class Story {
	
	private int storyNo;
	private String title;
	private String content1;
	private String content2;
	private String content3;
	private String content4;
	private String email;
	private Timestamp regDate;
	private int categoryNo;
	private int readCount;
	private int thank;
	private String nickname;
	private String picture; 
	private int imageNo;
	private String fileName;
	
	
	public Story() {}
	
	public Story(int storyNo, String title, String content1, String content2, String content3, String content4, String email, Timestamp regDate, int categoryNo, 
			int readCount, int thank, String nickname, int imageNo, String fileName) {
		
	    this.storyNo = storyNo;
	    this.title = title;
	    this.content1 = content1;
	    this.content2 = content2;
	    this.content3 = content3;
	    this.content4 = content4;
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

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}
	
	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}
	
	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}
	
	public String getContent4() {
		return content4;
	}

	public void setContent4(String content4) {
		this.content4 = content4;
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

	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
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
