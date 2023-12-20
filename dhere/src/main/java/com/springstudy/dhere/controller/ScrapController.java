package com.springstudy.dhere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springstudy.dhere.service.ScrapService;

@Controller
public class ScrapController {
	
	@Autowired
	private ScrapService scrapService;
	
	@RequestMapping(value= {"/scrap"}, method = RequestMethod.GET)
	public String Mypage(Model model) {
		model.addAllAttributes(scrapService.getScrapList());
		
		return "scrap";
	}
}
