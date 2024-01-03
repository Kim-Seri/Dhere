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

     // 게시물 가져오기(syj)
    public abstract Story getStoryDetail(int storyNo);
    
    // 게시물 디테일_이미지 가져오기(syj)
    public abstract List<Image> getStoryDetailImage(int storyNo);
    
    // 게시물 디테일_태그 가져오기(syj)
    public abstract List<Tag> getStoryDetailTag(int storyNo);
    
    // 게시물 조회 수 증가시키기(syj)
    public abstract void increaseReadCount(int storyNo);
    
    // 게시물 삭제하기(syj)
    public abstract void deleteStory(int storyNo);
	
	//직종 리스트 가져오기
	public abstract List<Job> getJobList();

	//게시글 이미지 추가하기
	public abstract void insertImage(Image image);

	//tag 추가하기
	public abstract void insertTag(Tag tag);
	
	//tagPost 추가하기
	public abstract  void insertTagPost(Tag tag);
	
	// 직종별 게시물 리스트 출력
	public abstract List<Story> storyList(String selectedJob);
}