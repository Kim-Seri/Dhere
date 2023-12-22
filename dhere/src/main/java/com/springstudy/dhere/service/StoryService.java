package com.springstudy.dhere.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Job;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.domain.Tag;

public interface StoryService {
	
	// 게시물 리스트 가져오기
	public abstract List<Story> getStoryList();

    // 게시물 쓰기
	public abstract void postWrite(Story story);

     // 게시물 가져오기 / seri02 수정
    public abstract List<Story> getStoryDetail(int storyNo);
	
	//직종 리스트 가져오기
	public abstract List<Job> getJobList();

	//게시글 이미지 추가하기
	public abstract void insertImage(Image image);
}