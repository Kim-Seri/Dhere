package com.springstudy.dhere.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.dhere.domain.Scrap;


@Repository
public class ScrapDaoImpl implements ScrapDao {
	
	private final String NAME_SPACE = "com.springstudy.dhere.mappers.ScrapMapper";
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Scrap> getScrapList() {
		return sqlSession.selectList(NAME_SPACE + ".scrap");
	}

	@Override
	public Scrap getScrap(int scrap_no) {
		// TODO Auto-generated method stub
		return null;
	}



}
