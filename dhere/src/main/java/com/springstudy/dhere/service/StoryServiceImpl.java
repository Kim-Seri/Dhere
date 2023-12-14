package com.springstudy.dhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.dao.StoryDao;
import com.springstudy.dhere.domain.Story;

@Service
public class StoryServiceImpl implements StoryService {

	@Autowired
	StoryDao storydao;
	
	@Override
	public List<Story> storyList() {
		return storydao.storyList();
	}

	@Override
	public Story getStory(int no) {
		return storydao.getStory(no);
	}

}
