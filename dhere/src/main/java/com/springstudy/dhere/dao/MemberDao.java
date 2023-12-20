package com.springstudy.dhere.dao;

import com.springstudy.dhere.domain.Member;

public interface MemberDao {
	
	// 로그인
	public abstract Member getMember(String email);

	// 회원가입
	public abstract void addMember(Member m);
}
