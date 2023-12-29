package com.springstudy.dhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.dao.StoryDao;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Job;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.domain.Tag;

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
	
	// 게시물 상세보기 
	@Override
	public List<Story> getStoryDetail(int storyNo) {
	    return storyDao.getStoryDetail(storyNo);
	}
	
	//직종 리스트 가져오기
	@Override
	public List<Job> getJobList(){
		List<Job> jList=storyDao.getJobList();
		System.out.println(jList);
		return storyDao.getJobList();
	}
	
	//게시물 이미지 추가하기
	@Override
	public void insertImage(Image image) {
		storyDao.insertImage(image);
	}	
	
	//tag추가하기
	@Override
	public void insertTag(Tag tag) {
		storyDao.insertTag(tag);
	}
	
	//tagPost추가하기
	@Override
	public void insertTagPost(Tag tag) {
		storyDao.insertTagPost(tag);
	}
}
