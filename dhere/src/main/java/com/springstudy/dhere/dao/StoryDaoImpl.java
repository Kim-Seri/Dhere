package com.springstudy.dhere.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Job;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.domain.Tag;

@Repository
public class StoryDaoImpl implements StoryDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static final String NAME_SPACE = "com.springstudy.dhere.mappers.StoryMapper";
	
	@Override
	public void postWrite (Story story) {
		sqlSession.insert(NAME_SPACE+".postWrite",story);
	}
	

	// 게시물 리스트 가져오기
	@Override
	public List<Story> getStoryList() {
		return sqlSession.selectList(NAME_SPACE + ".getStoryList");
	}

	// 게시물 디테일 가져오기
	@Override
	public Story getStoryDetail(int storyNo) {
	    return sqlSession.selectOne(NAME_SPACE + ".getStoryDetail", storyNo);
	}
	
	// 게시물 디테일_이미지 가져오기
	@Override
	public List<Image> getStoryDetailImage(int storyNo) {
		return sqlSession.selectList(NAME_SPACE + ".getStoryDetailImage", storyNo);
	}
	
	// // 게시물 디테일_태그 가져오기
	@Override
	public List<Tag> getStoryDetailTag(int storyNo) {
		return sqlSession.selectList(NAME_SPACE + ".getStoryDetailTag", storyNo);
	}
	
	// 게시물 조회 수 증가시키기
	@Override
	public void increaseReadCount(int storyNo) {
	    sqlSession.update(NAME_SPACE + ".increaseReadCount", storyNo);
	}
	
	 // 직종 리스트 가져오기
	@Override
	public List<Job> getJobList(){
		List<Job> jList=sqlSession.selectList(NAME_SPACE+".getJobList");
		System.out.println(jList);
		return sqlSession.selectList(NAME_SPACE+".getJobList");
	}
	
	// 게시글 이미지 추가하기
	@Override
	public void insertImage(Image image) {
		sqlSession.insert(NAME_SPACE+".insertImage",image);
	}
	
	//tag 추가하기
	@Override
	public void insertTag(Tag tag) {
		sqlSession.insert(NAME_SPACE+"insertTag", tag);
	}
	//tagPost추가하기
	@Override
	public void insertTagPost(Tag tag) {
		sqlSession.insert(NAME_SPACE+"insertTagPost", tag);
	}
}
