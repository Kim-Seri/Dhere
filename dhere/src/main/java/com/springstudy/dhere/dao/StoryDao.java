package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Job;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.domain.Tag;

public interface StoryDao {
    // 게시물 리스트 가져오기
    public abstract List<Story> getStoryList();

    // 게시물 디테일 가져오기
    public abstract Story getStoryDetail(int storyNo);
    
    // 게시물 디테일_이미지 가져오기
    public abstract List<Image> getStoryDetailImage(int storyNo);
    
    // 게시물 디테일_태그 가져오기
    public abstract List<Tag> getStoryDetailTag(int storyNo);
    
    // 게시물 조회 수 증가시키기
    public abstract void increaseReadCount(int storyNo);

    // 게시물 쓰기
	public abstract void postWrite(Story story);

	// 직종 리스트 가져오기
	public abstract List<Job> getJobList();

	// 게시글 이미지 입력하기
	public abstract void insertImage(Image image);

	//tag추가하기
	public abstract void insertTag(Tag tag);
	
	//tagPost추가하기
	public abstract void insertTagPost(Tag tag);


}