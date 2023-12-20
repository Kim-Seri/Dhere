package com.springstudy.dhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.dao.StoryDao;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;

@Service
public class StoryServiceImpl implements StoryService {
	
	@Autowired
	private StoryDao storyDao;
	

	
	// 게시물 리스트 가져오기
	@Override
	public List<Story> getStoryList() {
		
		return storyDao.getStoryList();
	}

	//게시글 작성하기(story)
	@Override
	public void postWrite(Story story) {
		storyDao.postWrite(story);
	}

}
