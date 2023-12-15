package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Story;

public interface StoryDao {
	
	// 게시물 리스트 가져오기
	public abstract List<Story> getStoryList();

	// 게시물 가져오기
	public abstract Story getStory(int no);

}
