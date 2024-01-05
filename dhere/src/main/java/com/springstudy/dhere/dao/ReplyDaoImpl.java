package com.springstudy.dhere.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.dhere.domain.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static final String NAME_SPACE = "com.springstudy.dhere.mappers.ReplyMapper";
	
	
	//	댓글 쓰기(syj)
	@Override
	public void replyWrite(Reply reply) {
		sqlSession.insert(NAME_SPACE+".replyWrite", reply);
	}

	//	댓글 리스트에 담아 가져오기(syj)
	@Override
    public List<Reply> getReply(int storyNo) {
        return sqlSession.selectList(NAME_SPACE+".getReply", storyNo);
    }
	
}