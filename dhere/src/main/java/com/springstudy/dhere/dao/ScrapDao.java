package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Scrap;

public interface ScrapDao {
	
	// 프로필 가져오기
	public abstract Scrap getScrap(String email);

	// 게시물 리스트 가져오기
	public abstract List<Scrap> getScrapList();
		
}
