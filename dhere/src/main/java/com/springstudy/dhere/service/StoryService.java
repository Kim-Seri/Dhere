package com.springstudy.dhere.service;

import java.util.List;
import java.util.Map;

import com.springstudy.dhere.domain.Story;

public interface StoryService {
	
	// 게시물 리스트 가져오기
	public abstract Map<String,Object> getStoryList();

	// 게시물 가져오기
	public abstract Story getStory(int no);

	public abstract void postWrite(Story story);

}
