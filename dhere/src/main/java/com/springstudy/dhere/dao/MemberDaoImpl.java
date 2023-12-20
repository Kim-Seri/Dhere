package com.springstudy.dhere.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.dhere.domain.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	private static final String NAME_SPACE="com.springstudy.dhere.mappers.MemberMapper";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//회원정보 가져오기
	@Override
	public Member getMember(String email) {
		return sqlSession.selectOne(NAME_SPACE+".getMember",email);
	}

	// 회원가입
	public void addMember(Member m) {
		sqlSession.insert(NAME_SPACE + ".addMember", m);
	}
	
}
