package com.springstudy.dhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.dao.ScrapDao;
import com.springstudy.dhere.domain.Scrap;


@Service
public class ScrapServiceImpl implements ScrapService {

	@Autowired
	private ScrapDao scrapDao;
	
	// 스크랩한거 읽어오기
	@Override
	public Map<String, Object> getScrapList() {
		Map <String, Object> param = new HashMap<>();
		List<Scrap> sc = scrapDao.getScrapList();
		param.put("sc", sc);
		return param;
	}

	// 스크랩한 게시물 가져오기
	@Override
	public Scrap getScrap(int scrap_no) {
		return scrapDao.getScrap(scrap_no);
	}

}
