package com.springstudy.dhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.dao.ScrapDao;
import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.domain.Scrap;

@Service
public class ScrapServiceImpl implements ScrapService {

	@Autowired
	private ScrapDao scrapDao;
	
	@Autowired
	private void setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
	}
	
	// 프로필 받아오기
	@Override
	public Scrap getScrap(String email) {
		return scrapDao.getScrap(email);
	}
	
	// 개인정보 수정 삭제할 때 비밀번호가 맞는지 체크
//	public boolean memberPassCheck(String email, String pass) {
//		boolean result = false;
//		String dbPass = scrapDao.memberPassCheck(email, pass);
		
//		if(dbPass.equals(pass)) {
//			result = true;
//		}
//			return result;
//	}
	
	// 스크랩한거 읽어오기
//	@Override
//	public List<Scrap> ScrapList() {
//		return scrapDao.getScrapList();
//	}


}
