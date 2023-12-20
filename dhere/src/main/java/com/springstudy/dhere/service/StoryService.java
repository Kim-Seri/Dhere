package com.springstudy.dhere.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;

public interface StoryService {
	
	// 게시물 리스트 가져오기
	public abstract List<Story> getStoryList();

    // 게시물 쓰기
	public abstract void postWrite(Story story);

     // 게시물 가져오기
    List<Story> getStoryDetail(int storyNo);

}