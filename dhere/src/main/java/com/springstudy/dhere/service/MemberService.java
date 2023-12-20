package com.springstudy.dhere.service;

import com.springstudy.dhere.domain.Member;

public interface MemberService {
	
	// 로그인 
	public abstract int login(String email,String pass);

	// 회원정보 가져오기
	public abstract Member getMember(String email);

	// 회원가입
	public abstract void addMember(Member m);
	
	//아이디 중복확인 메서드
	public abstract boolean overEmailCheck(String email);

}
