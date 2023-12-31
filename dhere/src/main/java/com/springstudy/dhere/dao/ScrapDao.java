package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.domain.Scrap;

public interface ScrapDao {
	
	// 프로필 가져오기
	public abstract Scrap getScrap(String email);

	// 게시물 리스트 가져오기
//	public abstract List<Scrap> getScrapList();
	
	// 게시물 상세보기 요청시 호출되는 메서드
//	public abstract Scrap getScrapPost(String email);
	
	// 1:1 문의하기 글쓰기
//	public abstract void insertCounselor(Scrap scrap);
	
	// 회원정보 수정할 때 비밀번호 체크에서 호출되는 메서드
	public String memberPassCheck(String email, String pass);
		
	// 1:1문의하기 수정삭제
	
	// 스크랩 수정삭제
	
	// 회원탈퇴
}
