package com.springstudy.dhere.service;

import com.springstudy.dhere.domain.Member;

public interface MemberService {
	
	public abstract int login(String email,String pass);

	public abstract Member getMember(String email);
	


}
