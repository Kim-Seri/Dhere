package com.springstudy.dhere.dao;

import com.springstudy.dhere.domain.Member;

public interface MemberDao {
	
	// 로그인
	public abstract Member getMember(String email);

	// 회원가입
	public abstract void addMember(Member m);

	//	//연지-가상
//	public interface MemberMapper {
//		Member getMember(
//			@Param("Email") String email,
//			@Param("password") String password);
//	
//	Member printOneByEmail(@Param("email") String email);
//	}
//	
}