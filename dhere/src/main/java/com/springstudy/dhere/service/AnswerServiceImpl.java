package com.springstudy.dhere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.dao.AnswerDao;
import com.springstudy.dhere.domain.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerDao answerdao;

	@Override
	public void insertAnswer(Answer answer) {
		answerdao.insertAnswer(answer);
	}

}
