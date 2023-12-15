package com.springstudy.dhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.dao.StoryDao;
import com.springstudy.dhere.domain.Story;

@Service
public class StoryServiceImpl implements StoryService {
	
	@Autowired
	private StoryDao storyDao;

	// 게시물 리스트 가져오기
	@Override
	public Map<String,Object> getStoryList() {
		Map<String,Object> param=new HashMap<>();
		List<Story> sList = storyDao.getStoryList();
		param.put("sList", sList);
		return param;
	}

	// 게시물 가져오기
	@Override
	public Story getStory(int no) {
		return storyDao.getStory(no);
	}

}
