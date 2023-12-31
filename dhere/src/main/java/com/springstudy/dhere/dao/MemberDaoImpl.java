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
		
	// 회원정보 수정시에 기존 비밀번호가 맞는지 체크하는 메서드
	public String memberPassCheck(String email, String Pass) {
		return sqlSession.selectOne(NAME_SPACE + ".memberPassCheck", email);
	}
		
	// 회원 정보 DAO를 이용해 회원 테이블에서 수정하는 메서드
	public void updateMember(Member member) {
		sqlSession.update(NAME_SPACE + ".updateMember", member);
	}
		
		
}
