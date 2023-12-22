package com.springstudy.dhere.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.domain.Scrap;
import com.springstudy.dhere.service.MemberService;
import com.springstudy.dhere.service.ScrapService;

@Controller
public class ScrapController {
	
	@Autowired
	private ScrapService scrapService;
	
	@Autowired
	private MemberService memberService;
	
	// 회원정보 받기
	@RequestMapping(value="/scrap", method=RequestMethod.GET)
	public String Profile
	(Model model,HttpSession session ,
			@RequestParam (defaultValue="test") String email) {
		
		Scrap scrap = scrapService.getScrap(email);
		Member member = ( Member) session.getAttribute("member");
		member.getNickname();
		member.getEmail();
		
		model.addAttribute("scrap", scrap);
		
		return "scrap";
	}
	
	// 스크랩 리스트 출력하기
//	@RequestMapping(value= {"/scrap"}, method = RequestMethod.GET)
//	public String scrapList(Model model) {
//		
//		List<Scrap> list = scrapService.ScrapList();
//		model.addAllAttributes(scrapService.ScrapList());
//		
//		return "scrap";
//	}
}
