package com.springstudy.dhere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springstudy.dhere.domain.Story;

@Service
public interface StoryService {
	
	/* 한 페이지에 보여 질 게시 글 리스트 요청 시 호출되는 메소드
	 * 현재 페이지에 해당하는 게시 글 리스트를 DB에서 읽어와 반환 하는 메소드
	 **/
	public abstract List<Story> storyList();
	
	
	public abstract Story getStory(int no);
	
}