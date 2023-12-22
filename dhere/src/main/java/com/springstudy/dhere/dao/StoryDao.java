package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Job;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;

public interface StoryDao {
    // 게시물 리스트 가져오기
   public abstract List<Story> getStoryList();

     // 게시물 가져오기
    public abstract List<Story> getStoryDetail(int storyNo);

    //게시글쓰기
	public abstract void postWrite(Story story);

	//직종 리스트 가져오기
	public abstract List<Job> getJobList();

	//게시글 이미지 입력하기
	public abstract void insertImage(Image image);

}