package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;

public interface StoryDao {
    // 게시물 리스트 가져오기
    List<Story> getStoryList();

     // 게시물 가져오기
    List<Story> getStoryDetail(int storyNo);

	public abstract void postWrite(Story story);

    

}