package com.springstudy.dhere.service;

import java.util.List;
import java.util.Map;

import com.springstudy.dhere.domain.Scrap;

public interface ScrapService {

	public abstract Map<String, Object> getScrapList();
	
	public abstract Scrap getScrap(int scrap_no);
}
