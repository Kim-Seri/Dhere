package com.springstudy.dhere.service;

import com.springstudy.dhere.domain.Member;

public interface MemberService {

	// 회원 가입
	public abstract void addMember(Member m);
	
	//아이디 중복확인 메서드
	public abstract boolean overEmailCheck(String id);
}
