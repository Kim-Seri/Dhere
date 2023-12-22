package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.domain.Tag;

public interface StoryDao {
    // 게시물 리스트 가져오기
    public abstract List<Story> getStoryList();

     // 게시물 가져오기
    public abstract List<Story> getStoryDetail(int storyNo);

    // 게시물 쓰기
	public abstract void postWrite(Story story);

}