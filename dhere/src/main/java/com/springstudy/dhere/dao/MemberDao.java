package com.springstudy.dhere.dao;

import com.springstudy.dhere.domain.Member;

public interface MemberDao {
	
	public abstract Member getMember(String email);
}
