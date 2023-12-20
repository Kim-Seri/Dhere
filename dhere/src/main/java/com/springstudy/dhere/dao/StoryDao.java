package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;

public interface StoryDao {
	
	// 게시물 리스트 가져오기
	public abstract List<Story> getStoryList();


	public abstract void postWrite(Story story);

}
