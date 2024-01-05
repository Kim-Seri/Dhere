package com.springstudy.dhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springstudy.dhere.dao.ReplyDao;
import com.springstudy.dhere.domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;
	

	//	댓글 쓰기(syj)
	@Override
	public void replyWrite(Reply reply) {
		replyDao.replyWrite(reply);
	}
	
	//	댓글 리스트에 담아 가져오기(syj)
	@Override
	public List<Reply> getReply(int storyNo) {
		return replyDao.getReply(storyNo);
	}
	
}