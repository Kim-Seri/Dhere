package com.springstudy.dhere.dao;

import com.springstudy.dhere.domain.Member;

public interface MemberDao {
	
	// 회원가입
	public abstract void addMember(Member m);
	
	
	public abstract Member getMember(String id);
}
