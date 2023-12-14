package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Story;


public interface StoryDao {
	
//////////////////////////////////////////////////////////	
	
	public abstract List<Story> storyList();
	
	public abstract Story getStory(int no);
	
}
