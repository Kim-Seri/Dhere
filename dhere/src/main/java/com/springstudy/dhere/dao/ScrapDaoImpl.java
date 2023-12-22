package com.springstudy.dhere.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.dhere.domain.Scrap;


@Repository
public class ScrapDaoImpl implements ScrapDao {
	
	
	private static final String NAME_SPACE = "com.springstudy.dhere.mappers.ScrapMapper";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 프로필 가져오기
	@Override
	public Scrap getScrap(String email) {
		return sqlSession.selectOne(NAME_SPACE + ".getScrap", email);
	}

	// 스크랩한 게시물 가져오기
	@Override
	public List<Scrap> getScrapList() {
		return sqlSession.selectList(NAME_SPACE + ".scrap");
	}


}
