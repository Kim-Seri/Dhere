package com.springstudy.dhere.service;

import java.util.List;
import java.util.Map;

import com.springstudy.dhere.domain.Scrap;

public interface ScrapService {
	
	// 회원 로그인을 처리하는 메서드
	//public int login(String email, String pass);
	
	// 마이페이지 프로필 정보 출력
	public Scrap getScrap(String email);
	
	// 스크랩리스트 출력
	public List<Scrap> ScrapList();
}