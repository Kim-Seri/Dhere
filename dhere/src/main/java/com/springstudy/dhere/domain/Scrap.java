package com.springstudy.dhere.domain;

import java.sql.Timestamp;

public class Scrap {
	
	private int scrap_No;
	private String email;
	private int story_no;
	private Timestamp scrap_date;
	
	private String title;
	private Timestamp reg_date;
	private String category_id;
	private int read_count;
	private int thank;
	private String nickname;
	
	private int image_no;
	private String file_name;
	private int no;
	public int getScrap_No() {
		return scrap_No;
	}
	public void setScrap_No(int scrap_No) {
		this.scrap_No = scrap_No;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStory_no() {
		return story_no;
	}
	public void setStory_no(int story_no) {
		this.story_no = story_no;
	}
	public Timestamp getScrap_date() {
		return scrap_date;
	}
	public void setScrap_date(Timestamp scrap_date) {
		this.scrap_date = scrap_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
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
	public int getImage_no() {
		return image_no;
	}
	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	

}
