package com.springstudy.dhere.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.dhere.domain.Story;

@Repository
public class StoryDaoImpl implements StoryDao {
	
@Autowired
private SqlSessionTemplate sqlSession;

private static final String NAME_SPACE = "com.springstudy.dhere.mapper.StoryMapper";

//////////////////////////////////////////////////////////	
	
	@Override
	public List<Story> storyList() {
		return sqlSession.selectList(NAME_SPACE + ".storyList");
	}

	
//////////////////////////////////////////////////////////	
	
	@Override
	public Story getStory(int no) {
		return sqlSession.selectOne(NAME_SPACE + ".getStory", no);
	}

}