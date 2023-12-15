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
	private static final String NAME_SPACE = "com.springstudy.dhere.mappers.StoryMapper";
	

	// 게시물 리스트 가져오기
	@Override
	public List<Story> getStoryList() {
		return sqlSession.selectList(NAME_SPACE + ".getStoryList");
	}

	// 게시물 가져오기
	@Override
	public Story getStory(int no) {
		return sqlSession.selectOne(NAME_SPACE + ".getStory", no);
	}

}
